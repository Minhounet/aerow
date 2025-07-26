package com.aerow.training.day1;

import static java.util.Objects.requireNonNull;

/*
 * Résoudre le problème suivante:
 *
 * Pour un nombre n > 0, retourner une chaîne de caractère où :
 * - les multiples de 3 sont remplacés par Ae
 * - les multiples de 5 sont remplacés par row
 * - les multiples de 15 sont remplacés par Aerow
 *
 * generate(1) => "1"
 * generate(2) => "12"
 * generate(3) => "12Ae"
 * generate(6) => "12Ae4row6"
 * etc...
 *
 * N'utilisez pas d'IA, utilisez la méthode TDD. L'IA est un accélérateur et ne doit pas diminuer vos compétences
 */

public class Problem1 {

    public static String generate(int nb) {
        failIfNbIsLowerOrEqualsThan1(nb);
        var result = new StringBuilder();
        for (int i = 1; i <= nb; i++) {
            result.append(translateNumber(i));
        }
        return result.toString();
    }

    private static String translateNumber(int it) {
        if (it % 15 == 0)
            return "Aerow";
        if (it % 3 == 0)
            return "Ae";
        if (it % 5 == 0)
            return "row";
        return String.valueOf(it);
    }

    private static void failIfNbIsLowerOrEqualsThan1(int nb) {
        if (nb <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        requireNonNull(args);
        requireNonNull(args[0], "missing nb!");
        System.out.println(Problem1.generate(Integer.parseInt(args[0])));
    }

}
