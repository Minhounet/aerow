package com.aerow.training.day2.mock.p1;

import java.util.function.Supplier;

/*
 * Renvoyer "ref-undefined" si la fonctionnalité n'est pas activé
 * Renvoyer String constitué de "ref-<nombre aleatoire>"
 */
public class ReferenceGenerator {

    private static final String PREFIX = "ref-";
    private static final String REF_UNDEFINED = PREFIX + "undefined";

    private final String id;

    private final FeatureFlagService featureFlagService;
    private final Supplier<Integer> randomNumberGenerator;

    public ReferenceGenerator(String id, FeatureFlagService featureFlagService, Supplier<Integer> randomNumberGenerator) {
        this.id = id;
        this.featureFlagService = featureFlagService;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String generate() {
        if (featureFlagService.isEnabled(id)) {
            return PREFIX + randomNumberGenerator.get();
        }
        return REF_UNDEFINED;
    }


}
