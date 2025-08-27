package com.aerow.training.day2.mock.p1;

import java.util.function.Supplier;

/*
 * Renvoyer "ref-undefined" si la fonctionnalité n'est pas activé
 * Renvoyer String constitué de "ref-<nombre aleatoire>"
 */
public class ReferenceGenerator {

    private final FeatureFlagService featureFlagService;
    private final Supplier<Integer> randomNumberGenerator;

    public ReferenceGenerator(FeatureFlagService featureFlagService,  Supplier<Integer> randomNumberGenerator) {
        this.featureFlagService = featureFlagService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int generate() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
