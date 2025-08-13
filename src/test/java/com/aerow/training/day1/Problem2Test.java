package com.aerow.training.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem2Test {

    @Test
    void should_return_1_When_roman_number_is_I() {
        assertEquals(1, Problem2.toDecimal("I"));
    }

    @Test
    void should_return_2_When_roman_number_is_II() {
        assertEquals(2, Problem2.toDecimal("II"));
    }

    @Test
    void should_return_3_When_roman_number_is_III() {
        assertEquals(3, Problem2.toDecimal("III"));
    }

    @Test
    void should_return_5_When_roman_number_is_V() {
        assertEquals(5, Problem2.toDecimal("V"));
    }

    @Test
    void should_return_6_When_roman_number_is_VI() {
        assertEquals(6, Problem2.toDecimal("VI"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_VII() {
        assertEquals(7, Problem2.toDecimal("VII"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_IV() {
        assertEquals(4, Problem2.toDecimal("IV"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_X() {
        assertEquals(10, Problem2.toDecimal("X"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_IX() {
        assertEquals(9, Problem2.toDecimal("IX"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_L() {
        assertEquals(50, Problem2.toDecimal("L"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_XL() {
        assertEquals(40, Problem2.toDecimal("XL"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_C() {
        assertEquals(100, Problem2.toDecimal("C"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_XC() {
        assertEquals(90, Problem2.toDecimal("XC"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_D() {
        assertEquals(500, Problem2.toDecimal("D"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_CD() {
        assertEquals(400, Problem2.toDecimal("CD"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_M() {
        assertEquals(1000, Problem2.toDecimal("M"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_MM() {
        assertEquals(2000, Problem2.toDecimal("MM"));
    }

    @Test
    void should_return_proper_nb_When_roman_number_is_CM() {
        assertEquals(900, Problem2.toDecimal("CM"));
    }

    @Test
    void should_return_proper_1443_When_roman_number_is_MCDXLIII() {
        assertEquals(1443, Problem2.toDecimal("MCDXLIII"));
    }
}