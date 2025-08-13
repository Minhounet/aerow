package com.aerow.training.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem3LegacyTest {

    @Test
    void Should_return_Easy_When_level_is_D() {
        assertEquals("Easy", Problem3Legacy.translateLevel("D"));
    }

    @Test
    void Should_return_Normal_When_level_is_C() {
        assertEquals("Normal", Problem3Legacy.translateLevel("C"));
    }

    @Test
    void Should_return_Hard_When_level_is_B() {
        assertEquals("Hard", Problem3Legacy.translateLevel("B"));
    }

    @Test
    void Should_return_Very_Hard_When_level_is_A() {
        assertEquals("Very Hard", Problem3Legacy.translateLevel("A"));
    }

    @Test
    void Should_return_Expert_For_any_other_value() {
        assertEquals("Expert", Problem3Legacy.translateLevel("Z"));
    }
}
