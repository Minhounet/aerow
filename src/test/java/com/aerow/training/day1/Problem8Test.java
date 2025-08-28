package com.aerow.training.day1;

import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class Problem8Test {

    @Test
    void should_return_option_none_When_nb_is_not_int_representation() {
        assertEquals(Option.none(), Problem8.toInt("yala"));
    }

    @Test
    void should_return_1_when_nb_is_un() {
        assertEquals(Option.of(1), Problem8.toInt("un"));
    }

    @Test
    void should_return_2_when_nb_is_deux() {
        assertEquals(Option.of(2), Problem8.toInt("deux"));
    }

    @Test
    void should_return_3_when_nb_is_trois() {
        assertEquals(Option.of(3), Problem8.toInt("trois"));
    }

    @Test
    void should_return_4_when_nb_is_quatre() {
        assertEquals(Option.of(4), Problem8.toInt("quatre"));
    }

    @Test
    void should_return_5_when_nb_is_cinq() {
        assertEquals(Option.of(5), Problem8.toInt("cinq"));
    }

    @Test
    void should_return_6_when_nb_is_six() {
        assertEquals(Option.of(6), Problem8.toInt("six"));
    }

    @Test
    void should_return_7_when_nb_is_sept() {
        assertEquals(Option.of(7), Problem8.toInt("sept"));
    }

    @Test
    void should_return_8_when_nb_is_huit() {
        assertEquals(Option.of(8), Problem8.toInt("huit"));
    }

    @Test
    void should_return_9_when_nb_is_neuf() {
        assertEquals(Option.of(9), Problem8.toInt("neuf"));
    }

    @Test
    void should_return_10_when_nb_is_dix() {
        assertEquals(Option.of(10), Problem8.toInt("dix"));
    }

    @Test
    void should_return_none_when_first_nb_is_incorrect() {
        assertEquals(Option.none(), Problem8.sum("une", "deux"));
    }

    @Test
    void should_return_none_when_second_nb_is_incorrect() {
        assertEquals(Option.none(), Problem8.sum("un", "deuxx"));
    }

    @Test
    void should_return_proper_sum_when_nb_are_correct() {
        assertEquals(Option.of(3), Problem8.sum("un", "deux"));
    }

    @Test
    void should_return_success_when_not_dividing_by_0() {
        assertEquals(Try.success(2), Problem8.divide(4, 2));
    }

    @Test
    void should_return_success_when_not_dividing_by_0_bis() {
        assertEquals(Try.success(3), Problem8.divide(6, 2));
    }

    @Test
    void should_return_failure_when_dividing_by_0() {
        Try<Integer> actual = Problem8.divide(6, 0);
        assertInstanceOf(ArithmeticException.class, actual.getCause());
    }

    @Test
    void should_return_1_to_100_sum_For_one_future() {
        var expectedSum = IntStream.rangeClosed(1, 100)
                .sum();
        assertEquals(expectedSum, Problem8.multipleSums(1));
    }


    @Test
    void should_return_sum_of_sum_For_2_futures() {
        var expectedSum = IntStream.rangeClosed(1, 100)
                .sum();
        assertEquals(expectedSum + expectedSum, Problem8.multipleSums(2));
    }

    @Test
    void should_return_sum_of_sum_For_3_futures() {
        var expectedSum = IntStream.rangeClosed(1, 100)
                .sum();
        assertEquals(expectedSum + expectedSum + expectedSum, Problem8.multipleSums(3));
    }



}