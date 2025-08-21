package com.aerow.training.day1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem4Test {


    private Problem4 p4;

    @BeforeEach
    void setUp() {
        p4 = new Problem4();
    }

    @Test
    void should_compute_word_size() {
        assertEquals(List.of(4), p4.funkyTransform(List.of("cinq")));
    }

    @Test
    void should_compute_another_word_size() {
        assertEquals(List.of(8), p4.funkyTransform(List.of("quatorze")));
    }


    @Test
    void should_add_0_between_number() {
        assertEquals(List.of(2, 0, 5), p4.funkyTransform(List.of("je", "pense")));
    }
}