package com.aerow.training.day2and3.core.usecase;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;

import java.util.List;

/**
 * Implémentation de {@link GetAllWordsUseCase}, à vous de jouer!
 */
public class DefaultGetAllWordsUseCase implements GetAllWordsUseCase {

    private final WordRepository wordRepository;

    public DefaultGetAllWordsUseCase(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public GetAllWordsUseCaseResponse getAllWords() {
        return new GetAllWordsUseCaseResponse(List.of(new Word()));
    }
}
