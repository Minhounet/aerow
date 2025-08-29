package com.aerow.training.day2and3.core.usecase;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultGetAllWordsUseCaseTest {

    @Mock
    private WordRepository wordRepository;

    @InjectMocks
    private DefaultGetAllWordsUseCase defaultGetAllWordsUseCase;

    @Test
    void Should_return_all_words() {
        Word m1 = Word.from("id1", "word1");
        Word m2  = Word.from("id2", "word2");
        Word m3  = Word.from("id3", "word3");
        when(wordRepository.getAll()).thenReturn(List.of(m1, m2, m3));
        assertEquals(new GetAllWordsUseCaseResponse(List.of(m1, m2, m3)), defaultGetAllWordsUseCase.getAllWords());
    }
}