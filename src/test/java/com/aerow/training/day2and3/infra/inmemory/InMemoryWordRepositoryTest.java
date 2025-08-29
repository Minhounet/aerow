package com.aerow.training.day2and3.infra.inmemory;

import com.aerow.training.day2and3.core.domain.DuplicateWordIdException;
import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryWordRepositoryTest {

    private final ConcurrentMap<String, Word> words = new ConcurrentHashMap<>();
    private final InMemoryWordRepository repository = new InMemoryWordRepository(words);

    @Test
    void should_saved_word_in_memory() {
        repository.save(Word.from("id1", "word"));
        assertEquals(Word.from("id1", "word") ,  words.get("id1"));
    }

    @Test
    void should_throw_exception_if_word_already_exist() {
        words.put("id1", Word.from("id1", "word"));
        var e = assertThrows(DuplicateWordIdException.class, () -> repository.save(Word.from("id1", "word")));
        assertEquals("word id id1 already used", e.getMessage());
    }

    @Test
    void should_return_true_if_word_exist() {
        words.put("id1", Word.from("id1", "word"));
        assertTrue(repository.exists(new WordId("id1")));
    }

    @Test
    void should_return_all_value() {
        words.put("id1", Word.from("id1", "word"));
        words.put("id2", Word.from("id2", "word2"));
        List<Word> actual = repository.getAll();
        assertEquals(2, actual.size());
        assertTrue(actual.contains(Word.from("id1", "word")));
        assertTrue(actual.contains(Word.from("id2", "word2")));
    }
}
