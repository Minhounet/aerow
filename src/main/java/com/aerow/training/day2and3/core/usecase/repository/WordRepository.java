package com.aerow.training.day2and3.core.usecase.repository;

import com.aerow.training.day2and3.core.domain.Word;

import java.util.List;

public interface WordRepository {

    void save(Word word);

    List<Word> getAll();

}
