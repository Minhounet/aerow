package com.aerow.training.day2.mock.p1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReferenceGeneratorTest {

    @Mock
    private FeatureFlagService featureFlagService;

    @Mock
    private Supplier<Integer> randomGenerator;

    private ReferenceGenerator referenceGenerator;

    @BeforeEach
    void setUp() {
        referenceGenerator = new ReferenceGenerator("kebabId", featureFlagService, randomGenerator);
    }

    @Test
    void should_return_ref_undefined_When_feature_is_disabled() {
        // lenient est important pour le tdd pur!
        lenient().when(featureFlagService.isEnabled("kebabId")).thenReturn(false);
        assertEquals("ref-undefined", referenceGenerator.generate());
    }

    @Test
    void should_return_ref_10_When_feature_is_enabled() {
        when(featureFlagService.isEnabled("kebabId")).thenReturn(true);
        when(randomGenerator.get()).thenReturn(10);
        assertEquals("ref-10", referenceGenerator.generate());
    }

    @Test
    void should_return_ref_11_When_feature_is_enabled() {
        when(featureFlagService.isEnabled("kebabId")).thenReturn(true);
        when(randomGenerator.get()).thenReturn(11);
        assertEquals("ref-11", referenceGenerator.generate());
    }


}