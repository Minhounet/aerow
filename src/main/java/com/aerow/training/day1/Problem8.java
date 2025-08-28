package com.aerow.training.day1;

import io.vavr.concurrent.Future;
import io.vavr.control.Option;
import io.vavr.control.Try;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.IntStream;

/*
 * vavr la magie de la programmation fonctionnelle
 *
 * https://docs.vavr.io/
 */
public class Problem8 {

    private static final Map<String, Integer> TO_INT = Map.of(
            "un", 1,
            "deux", 2,
            "trois", 3,
            "quatre", 4,
            "cinq", 5,
            "six", 6,
            "sept", 7,
            "huit", 8,
            "neuf", 9,
            "dix", 10
    );

    // Reconnaître un, deux, trois ... -> dix et renvoyer l'entier correspond si possible
    public static Option<Integer> toInt(String nbAsString) {
        return Option.of(nbAsString)
                .flatMap(v -> Option.of(TO_INT.get(v)));
    }

    // Additionner les deux nbs
    public static Option<Integer> sum(String nb1, String nb2) {
        Option<Integer> o1 = Problem8.toInt(nb1);
        Option<Integer> o2 = Problem8.toInt(nb2);
        return Option.sequence(List.of(o1, o2))
                .map(seq -> seq.get(0) + seq.get(1));
    }

    // Diviser n1 par n2 et gérer le cas n2 = 0
    public static Try<Integer> divide(int n1, int n2) {
        return Try.of(() -> n1 / n2);
    }

    // Faire la somme des nb de 1 à 100 et tout additionner selon le nb de futures
    // si nbOfFutures = 1, 1 + 2 + 3 .. + 100
    // si nbOfFutures = 2
    // 1 + 2 + 3 .. + 100 en parallèlte de 1 + 2 + 3 .. + 100 et additionner les deux séries
    // Utiliser un future par calcul et combiner le tout
    public static int multipleSums(int nbOfFutures) {
        Function<Integer, Future<Integer>> futureSum1To100 = i -> Future.of(() -> IntStream.rangeClosed(1, 100).sum());
        BinaryOperator<Future<Integer>> sumFutures = (f1, f2) -> Future.of(() -> f1.get() + f2.get());

        return IntStream.range(0, nbOfFutures)
                .boxed()
                .map(futureSum1To100)
                .reduce(Future.successful(0),
                        sumFutures)
                .onComplete(f -> System.out.println("A ne pas faire mais la somme est : " + f.get()))
                .get();
    }

}
