package com.aerow.training.day2and3.core.usecase;

import com.aerow.training.day2and3.core.domain.Word;

import java.util.List;

public record GetAllWordsUseCaseResponse(List<Word> words) {
}
