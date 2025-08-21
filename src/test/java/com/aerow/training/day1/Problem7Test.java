package com.aerow.training.day1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Problem7Test {

    @Test
    void should_return_0_when_list_is_empty() {
        assertEquals(0, Problem7.sumDouble(List.of()));
    }

    @Test
    void should_return_4_when_list_has_one_element_equals_to_2() {
        assertEquals(4, Problem7.sumDouble(List.of(2)));
    }

    @Test
    void should_return_20_when_list_is_2_4() {
        assertEquals(20, Problem7.sumDouble(List.of(2,4)));
    }
}