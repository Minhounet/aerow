package com.aerow.training.day2and3.infra.jpa;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;

import java.util.List;
import java.util.function.Function;
import java.util.stream.StreamSupport;

public class JpaWordRepository implements WordRepository {

    private final CrudWordRepository crudWordRepository;

    public JpaWordRepository(CrudWordRepository crudWordRepository) {
        this.crudWordRepository = crudWordRepository;
    }

    @Override
    public void save(Word word) {
        WordEntity wordEntity = new WordEntity(word.getWordId().id(), word.getWord(), word.getWordLength());
        crudWordRepository.save(wordEntity);
    }

    @Override
    public List<Word> getAll() {
        Iterable<WordEntity> all = crudWordRepository.findAll();

        Function<WordEntity, Word> mapToWord = entity -> {
            var word = Word.from(entity.getId(), entity.getWord());
            word.setWordLength(word.getWordLength()); // is redundant but ok ok
            return word;
        };

        return StreamSupport.stream(all.spliterator(), false)
                .map(mapToWord)
                .toList();
    }

    @Override
    public boolean exists(WordId wordId) {
        return crudWordRepository.existsById(wordId.id());
    }
}
