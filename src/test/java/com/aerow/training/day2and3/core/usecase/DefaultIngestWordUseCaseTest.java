package com.aerow.training.day2and3.core.usecase;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;
import com.aerow.training.day2and3.core.usecase.service.IdGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DefaultIngestWordUseCaseTest {

    @Mock
    private WordRepository wordRepository;

    @Mock
    private IdGenerator idGenerator;

    @InjectMocks
    private DefaultIngestWordUseCase defaultIngestWordUseCase;

    @Test
    void should_return_unique_id_When_ingesting_word() {
        lenient().when(idGenerator.generateId()).thenReturn("id1");
        IngestWordUseCaseRequest request = new IngestWordUseCaseRequest("word");
        assertEquals(new IngestWordUseCaseResponse("id1"), defaultIngestWordUseCase.ingestWord(request));
        assertNotNull(idGenerator);
    }

    @Test
    void should_return_unique_id_When_ingesting_word_bis() {
        lenient().when(idGenerator.generateId()).thenReturn("id2");
        IngestWordUseCaseRequest request = new IngestWordUseCaseRequest("word");
        assertEquals(new IngestWordUseCaseResponse("id2"), defaultIngestWordUseCase.ingestWord(request));
        assertNotNull(idGenerator);
    }

    @Test
    void should_save_word_in_repository() {
        when(idGenerator.generateId()).thenReturn("id3");
        defaultIngestWordUseCase.ingestWord(new IngestWordUseCaseRequest("word"));
        Word expectedWord = Word.from("id3", "word");
        verify(wordRepository, times(1)).save(expectedWord);
    }

    @Test
    void should_save_word_with_unused_id() {
        when(idGenerator.generateId()).thenReturn("id1", "id2", "id3");
        when(wordRepository.exists(new WordId("id1"))).thenReturn(true);
        when(wordRepository.exists(new WordId("id2"))).thenReturn(true);
        defaultIngestWordUseCase.ingestWord(new IngestWordUseCaseRequest("word"));
        Word expectedWord = Word.from("id3", "word");
        verify(wordRepository, times(1)).save(expectedWord);
    }

    @Test
    void should_have_word_with_proper_length() {
        when(idGenerator.generateId()).thenReturn("id3");
        defaultIngestWordUseCase.ingestWord(new IngestWordUseCaseRequest("IPSSI"));
        Word expectedWord = Word.from("id3", "IPSSI");
        expectedWord.setWordLength(5);
        verify(wordRepository, times(1)).save(expectedWord);
    }
}