package com.aerow.training.day2.mock.p2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AerowUseCaseTest {

    @Mock
    private IpssiRepository ipssiRepository;

    @InjectMocks
    private AerowUseCase aerowUseCase;

    @Test
    void Should_return_true_When_id_is_registered() {
        lenient().when(ipssiRepository.exists("blabla")).thenReturn(false);
        assertTrue(aerowUseCase.register("blabla"));
    }

    @Test
    void Should_return_true_When_another_id_is_not_registered() {
        lenient().when(ipssiRepository.exists("peppa")).thenReturn(false);
        assertTrue(aerowUseCase.register("peppa"));
    }

    @Test
    void should_save_id_when_not_registered() {
        lenient().when(ipssiRepository.exists("coucou")).thenReturn(false);
        aerowUseCase.register("coucou");
        verify(ipssiRepository, times(1)).save("coucou");
    }

    @Test
    void should_return_false_if_id_is_already_registred() {
        when(ipssiRepository.exists("caca")).thenReturn(true);
        aerowUseCase.register("caca");
        verify(ipssiRepository, never()).save("caca");
    }
}