package com.aerow.training.day1;

import io.vavr.control.Option;
import io.vavr.control.Try;

/*
 * vavr la magie de la programmation fonctionnelle
 *
 * https://docs.vavr.io/
 */
public class Problem8 {

    // Reconnaître un, deux, trois ... -> dix et renvoyer l'entier correspond si possible
    public static Option<Integer> toInt(String nbAsString) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Additionner les deux nbs
    public static Option<Integer> sum(String nb1, String nb2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Diviser n1 par n2 et gérer le cas n2 = 0
    public static Try<Integer> divide(int n1, int n2) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // Faire la somme des nb de 1 à 100 et tout additionner selon le nb de futures
    // si nbOfFutures = 1, 1 + 2 + 3 .. + 100
    // si nbOfFutures = 2
    // 1 + 2 + 3 .. + 100 en parallèlte de 1 + 2 + 3 .. + 100 et additionner les deux séries
    // Utiliser un future par calcul et combiner le tout
    public static int multipleSums(int nbOfFutures) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
