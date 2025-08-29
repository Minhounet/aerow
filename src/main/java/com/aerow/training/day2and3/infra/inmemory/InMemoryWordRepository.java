package com.aerow.training.day2and3.infra.inmemory;

import com.aerow.training.day2and3.core.domain.DuplicateWordIdException;
import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

/**
 * A vous d'implémenter la version en mémoire de la base de données des mots
 */
public class InMemoryWordRepository implements WordRepository {

    private final ConcurrentMap<String, Word> words;

    public InMemoryWordRepository(ConcurrentMap<String, Word> words) {
        this.words = words;
    }

    @Override
    public void save(Word word) {
        String wordId = word.getWordId().id();
        if (null != words.get(wordId)) {
            throw new DuplicateWordIdException(wordId);
        }
        words.put(wordId, word);
    }

    @Override
    public List<Word> getAll() {
        return words.values()
                .stream()
                .toList();

    }

    @Override
    public boolean exists(WordId wordId) {
        return words.containsKey(wordId.id());
    }
}
