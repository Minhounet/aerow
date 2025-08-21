package com.aerow.training.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem6Test {

    @Test
    void should_return_word_size_if_sentence_has_one_word() {
        assertEquals(5, Problem6.specialDivide("mange"));
    }

    @Test
    void should_return_word_size_if_sentence_has_another_word() {
        assertEquals(6, Problem6.specialDivide("mangez"));
    }

    @Test
    void should_return_proper_if_sentence_has_two_word() {
        assertEquals(5, Problem6.specialDivide("mangez ceci"));
    }

    @Test
    void should_handle_quote() {
        assertEquals(2, Problem6.specialDivide("j'ai faim"));
    }

    @Test
    void should_multiple_space() {
        assertEquals(2, Problem6.specialDivide("j'   ai    faim"));
    }
}