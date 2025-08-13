package com.aerow.training.day1;

import java.util.Map;

/*
 * Calculer le nombre à partir d'un chiffre romain.
 * I = 1
 * II = 2
 * III = 3
 * IV = 4
 * V = 5
 * ...
 * IX = 9
 *
 * X = 10
 *
 * XL = 40
 * L = 50
 * LX = 60
 *
 * XC = 90
 * C = 100
 *
 * CD = 400
 * D = 500
 * DC = 600
 *
 * M = 1000
 * MM = 2000
 * MMM = 3000
 */
public class Problem2 {

    private static final Map<Character, Character> MAPPING_SUBTRACT = Map.of(
            'V', 'I',
            'X', 'I',
            'L', 'X',
            'C', 'X',
            'D', 'C',
            'M', 'C'
    );

    private static final Map<Character, Integer> MAPPING_ROMAN_TO_DECIMAL = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );


    public static int toDecimal(String romanNumber) {
        int result = 0;
        char[] tokens = romanNumber.toCharArray();
        char previousToken = tokens[0];
        for (char token : tokens) {
            result += MAPPING_ROMAN_TO_DECIMAL.get(token);
            Character subtractCandidate = MAPPING_SUBTRACT.get(token);
            if (null != subtractCandidate && previousToken == subtractCandidate) {
                result = result - 2 * MAPPING_ROMAN_TO_DECIMAL.get(subtractCandidate);
            }
            previousToken = token;
        }
        return result;
    }
    
}
