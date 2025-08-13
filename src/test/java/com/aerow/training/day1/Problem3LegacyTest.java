package com.aerow.training.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem3LegacyTest {

    @Test
    void Should_return_Easy_When_level_is_D() {
        assertEquals("Easy", Problem3Legacy.translateLevel("D", "en"));
    }

    @Test
    void Should_return_Normal_When_level_is_C() {
        assertEquals("Normal", Problem3Legacy.translateLevel("C", "en"));
    }

    @Test
    void Should_return_Hard_When_level_is_B() {
        assertEquals("Hard", Problem3Legacy.translateLevel("B", "en"));
    }

    @Test
    void Should_return_Very_Hard_When_level_is_A() {
        assertEquals("Very Hard", Problem3Legacy.translateLevel("A", "en"));
    }

    @Test
    void Should_return_Expert_For_any_other_value() {
        assertEquals("Expert", Problem3Legacy.translateLevel("Z", "en"));
    }

    @Test
    void Should_return_Facile_When_level_is_D_as_fr() {
        assertEquals("Facile", Problem3Legacy.translateLevel("D", "fr"));
    }

    @Test
    void Should_return_Normal_When_Level_is_C_as_fr() {
        assertEquals("Normal", Problem3Legacy.translateLevel("C", "fr"));
    }

    @Test
    void Should_return_Difficile_When_Level_is_B_as_fr() {
        assertEquals("Difficile", Problem3Legacy.translateLevel("B", "fr"));
    }

    @Test
    void Should_return_Tres_Difficile_When_Level_is_A_as_fr() {
        assertEquals("Très Difficile", Problem3Legacy.translateLevel("A", "fr"));
    }
}
