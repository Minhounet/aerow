package com.aerow.training.day2and3.configuration.spring.controller;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.usecase.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WordControllerTest {

    @Mock
    private IngestWordUseCase ingestWordUseCase;

    @Mock
    private GetAllWordsUseCase getAllWordsUseCase;

    @InjectMocks
    private WordController controller;

    @Test
    void should_return_proper_response_entity_When_word_is_ingested() {
        when(ingestWordUseCase.ingestWord(new IngestWordUseCaseRequest("myWord"))).thenReturn(new IngestWordUseCaseResponse("anyId"));
        assertEquals(ResponseEntity.ok("anyId"), controller.saveWord("myWord"));
    }

    @Test
    void should_return_error_response_When_an_error_occurs() {
        when(ingestWordUseCase.ingestWord(any())).thenThrow(new RuntimeException());
        assertEquals(ResponseEntity.internalServerError().build(), controller.saveWord("myWord"));
    }

    @Test
    void should_return_error_response() {
        when(getAllWordsUseCase.getAllWords()).thenThrow(new RuntimeException());
        assertEquals(ResponseEntity.internalServerError().build(), controller.getAllWords());
    }

    @Test
    void should_return_success_response_When_getting_all_words() {
        List<Word>  words = List.of(Word.from("id1", "word1"), Word.from("id2", "worde2"), Word.from("id3", "wordee3"));
        GetAllWordsUseCaseResponse response = new GetAllWordsUseCaseResponse(words);
        when(getAllWordsUseCase.getAllWords()).thenReturn(response);
        WordEntry w1 = new WordEntry("id1", "word1", 5);
        WordEntry w2 = new WordEntry("id2", "worde2", 6);
        WordEntry w3 = new WordEntry("id3", "wordee3", 7);
        var expected = ResponseEntity.ok(List.of(w1, w2, w3));
        assertEquals(expected, controller.getAllWords());
    }
}