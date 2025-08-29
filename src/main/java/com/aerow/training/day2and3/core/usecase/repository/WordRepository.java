package com.aerow.training.day2and3.core.usecase.repository;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;

import java.util.List;

/**
 * Pour stocker, retrouver les mots dans une base
 */
public interface WordRepository {

    void save(Word word);

    List<Word> getAll();

    boolean exists(WordId wordId);

}
