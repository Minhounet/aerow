package com.aerow.training.day1;

/*
 * Code legacy, sécuriser avec des tests d'abord.
 *
 * Refactoriser le code
 *
 * Gérer la langue fr/en
 */
public class Problem3Legacy {

    public static String translateLevel(String levelCode) {
        if (levelCode.equals("D")) {
            return "Easy";
        } else if (levelCode.equals("C")) {
            return "Normal";
        } else if (levelCode.equals("B")) {
            return "Hard";
        } else if (levelCode.equals("A")) {
            return "Very Hard";
        }
        return "Expert";
    }
}
