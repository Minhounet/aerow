package com.aerow.training.day1;

/*
 * Code legacy, sécuriser avec des tests d'abord.
 *
 * Refactoriser le code
 *
 * Gérer la langue fr/en
 */
public class Problem3Legacy {

    public static String translateLevel(String levelCode, String language) {
        if (language.equals("fr")) {
            return "Facile";
        }
        return switch (levelCode) {
            case "D" -> "Easy";
            case "C" -> "Normal";
            case "B" -> "Hard";
            case "A" -> "Very Hard";
            default -> "Expert";
        };
    }
}
