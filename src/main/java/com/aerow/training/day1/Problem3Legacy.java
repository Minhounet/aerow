package com.aerow.training.day1;

import java.util.Map;

/*
 * Code legacy, sécuriser avec des tests d'abord.
 *
 * Refactoriser le code
 *
 * Gérer la langue fr/en
 */
public class Problem3Legacy {

    private static final Map<String, String> FRENCH_LEVELS = Map.of(
            "D", "Facile",
            "B", "Difficile",
            "A", "Très Difficile"
    );

    private static final Map<String, String> ENGLISH_LEVELS = Map.of(
            "D", "Easy",
            "B", "Hard",
            "A", "Very Hard"
    );
    public static final String LEVEL_EXPERT = "Expert";


    public static String translateLevel(String levelCode, String language) {
        if ("C".equals(levelCode)) {
            return "Normal";
        }
        if (language.equals("fr")) {
            return FRENCH_LEVELS.getOrDefault(levelCode, LEVEL_EXPERT);
        }
        return ENGLISH_LEVELS.getOrDefault(levelCode, LEVEL_EXPERT);
    }
}
