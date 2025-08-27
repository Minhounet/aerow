package com.aerow.training.day2.mock.p3;

import com.aerow.training.day2.mock.p2.IpssiRepository;

/*
 * Sauvegarder l'élément mangé dans la base seulement si c'est bon.
 * Si ce n'est pas bon, lancer l'exception FoodNotGoodException
 */
public class MyFamousArgumentMatcher {

    private final IpssiRepository ipssiRepository;

    public MyFamousArgumentMatcher(IpssiRepository ipssiRepository) {
        this.ipssiRepository = ipssiRepository;
    }

    public void eat(IpssiFood food) {
        throw new UnsupportedOperationException();
    }

}
