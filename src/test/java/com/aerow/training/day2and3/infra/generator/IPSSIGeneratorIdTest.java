package com.aerow.training.day2and3.infra.generator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IPSSIGeneratorIdTest {

    @Test
    void should_return_value_from_supplier() {
        IPSSIGeneratorId ipssiGeneratorId = new IPSSIGeneratorId(() -> "yala");
        assertEquals("yala", ipssiGeneratorId.generateId());
    }

    @Test
    void should_return_value_bis_from_supplier() {
        IPSSIGeneratorId ipssiGeneratorId = new IPSSIGeneratorId(() -> "kebab");
        assertEquals("kebab", ipssiGeneratorId.generateId());
    }
}