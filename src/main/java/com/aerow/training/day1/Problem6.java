package com.aerow.training.day1;

import io.vavr.Lazy;

import java.util.List;
import java.util.function.Function;

/*
 * Soit une phrase :
 * Renvoyer un entier qui correspond à la division (troncature) entre le nombre de lettres et le nombre de mots.
 * Exemple: "j'aime cette formation" => 18/4 = 4.
 *
 * Comme d'habitude, pas de boucle etc...
 */
public class Problem6 {

    // My funny solution
    public static int specialDivide(String sentence) {
        Lazy<List<String>> tokens = Lazy.of(() -> List.of(sentence.split("[ ']")));

        Function<List<String>, List<Integer>> intWithoutEmptyWordsFn = l ->
                l.stream()
                        .map(String::length)
                        .filter(s -> s > 0)
                        .toList();

        Function<List<Integer>, Integer> sumAndDivide = l -> l.stream()
                .reduce(0, Integer::sum)
                / l.size();

        Function<List<String>, Integer> doIt = sumAndDivide.compose(intWithoutEmptyWordsFn);

        return tokens.map(doIt).get();
    }

}
