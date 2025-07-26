package com.aerow.training.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Problem1Test {

    // A supprimer, on test notre framework de test avant de commencer, on ne sait jamais...
    @Test
    void doNothing() {
        assertDoesNotThrow(() -> {
        });
    }

    @Test
    void should_throw_illegalArgument_when_nb_is_lower_than_1() {
        assertThrows(IllegalArgumentException.class, () -> Problem1.generate(-3));
    }

    @Test
    void should_return_1_when_nb_is_1() {
        assertEquals("1",  Problem1.generate(1));
    }

    @Test
    void should_return_12_when_nb_is_2() {
        assertEquals("12",  Problem1.generate(2));
    }

    @Test
    void should_return_12Ae_when_nb_is_3() {
        assertEquals("12Ae",  Problem1.generate(3));
    }

    @Test
    void should_return_12Ae4_when_nb_is_4() {
        assertEquals("12Ae4",  Problem1.generate(4));
    }

    @Test
    void should_return_12Ae4row_when_nb_is_5() {
        assertEquals("12Ae4row",  Problem1.generate(5));
    }

    @Test
    void should_return_12Ae4rowAe_when_nb_is_6() {
        assertEquals("12Ae4rowAe",  Problem1.generate(6));
    }

    @Test
    void should_return_relevant_value_when_nb_is_10() {
        assertEquals("12Ae4rowAe78Aerow",  Problem1.generate(10));
    }

    @Test
    void should_return_relevant_value_when_nb_is_15() {
        assertEquals("12Ae4rowAe78Aerow11Ae1314Aerow",  Problem1.generate(15));
    }
}