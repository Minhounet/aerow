package com.aerow.training.day1;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/*
 * Entrée : liste de String
 * Sortie : liste d'entiers de la forme suivante:
 * - il s'agit de la taille de chaque mot multiplé par deux
 * - mettre des 0 entre chaque nombre
 *
 * Exemple : ["je", "suis", "ici", "et", "là"]
 * Sortie : [4, 0, 8, 0, 6, 0, 4, 0, 4]
 *
 * consigne : pas de boucle ! que du fonctionnel
 *
 */
public class Problem4 {

    private static final Function<List<String>, List<Integer>> TO_LENGTH =
            l -> l.stream()
                    .map(String::length)
                    .toList();

    private static final Function<List<Integer>, List<Integer>> INSERT_ZERO =
            l -> l.stream()
                    .flatMap(length -> Stream.of(length, 0))
                    .toList();


    private static final Function<List<Integer>, List<Integer>> REMOVE_LAST_ELEMENT =
            l -> l.isEmpty() ? List.of() : l.subList(0, l.size() - 1);

    public List<Integer> funkyTransform(List<String> input) {
       return TO_LENGTH
               .andThen(INSERT_ZERO)
               .andThen(REMOVE_LAST_ELEMENT)
               .apply(input);
    }
}
