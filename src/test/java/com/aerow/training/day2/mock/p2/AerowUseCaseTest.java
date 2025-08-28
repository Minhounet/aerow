package com.aerow.training.day2.mock.p2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AerowUseCaseTest {

    @Mock
    private IpssiRepository ipssiRepository;

    @InjectMocks
    private AerowUseCase aerowUseCase;


    @Test
    void Should_return_false_When_id_is_already_registered() {
        lenient().when(ipssiRepository.exists("ipssi")).thenReturn(true);
        assertFalse(aerowUseCase.register("ipssi"));
    }

    @Test
    void should_return_true_when_id_is_not_registered_yet() {
        when(ipssiRepository.exists("ipssi")).thenReturn(false);
        assertTrue(aerowUseCase.register("ipssi"));
    }

    @Test
    void should_register_id_When_it_is_not_registered_yet() {
        when(ipssiRepository.exists("ipssi")).thenReturn(false);
        aerowUseCase.register("ipssi");
        verify(ipssiRepository, times(1)).save("ipssi");
    }
}