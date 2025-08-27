package com.aerow.training.day2and3.infra.inmemory;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;

import java.util.List;

public class InMemoryWordRepository implements WordRepository {
    @Override
    public void save(Word word) {

    }

    @Override
    public List<Word> getAll() {
        return List.of();
    }
}
