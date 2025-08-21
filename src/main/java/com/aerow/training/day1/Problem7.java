package com.aerow.training.day1;

import java.util.List;

/*
 * Soit une liste de nombre, faire la somme des carrés de manière récursive et tail rec.
 *
 * vous avez le droit de récupérer le premier élément de la liste et de faire un sublist pour récupérer le reste
 * on évite d'utiliser du tout fait pour l'exercice
 */
public class Problem7 {
    public static int sumDouble(List<Integer> numbers) {
        return sumDouble(numbers, 0);
    }

    private static int sumDouble(List<Integer> numbers, int acc) {
        if (numbers.isEmpty()) {
            return acc;
        } else {
            return sumDouble(numbers.subList(1, numbers.size()), (int) (acc + Math.pow(numbers.get(0), 2)));
        }
    }
}
