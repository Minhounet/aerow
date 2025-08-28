package com.aerow.training.day2.mock.p3;

import com.aerow.training.day2.mock.p2.IpssiRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class MyFamousArgumentMatcherTest {

    @Mock
    private IpssiRepository ipssiRepository;

    @InjectMocks
    private MyFamousArgumentMatcher matcher;

    @Test
    void should_throw_FoodNotGoodException_When_food_is_no_good() {
        var badFood = new IpssiFood("macdo", false);
        var e = assertThrows(FoodNotGoodException.class, () -> matcher.eat(badFood));
        assertEquals("macdo is not good", e.getMessage());
    }

    @Test
    void should_save_food_When_it_is_good() {
        var goodFood = new IpssiFood("Junk burgers", true);
        matcher.eat(goodFood);
        verify(ipssiRepository, times(1)).save("Junk burgers");
    }
}