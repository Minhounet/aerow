package com.aerow.training.day2and3.configuration.spring.controller;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;
import com.aerow.training.day2and3.core.usecase.GetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCaseRequest;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCaseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Vos deux endpoints, un pour sauvegarder un mot et l'autre pour tous les récupérer,
 * à vous d'utiliser les "use cases".
 *
 */
@RestController
@RequestMapping("/words")
public class WordController {

    private final GetAllWordsUseCase  getAllWordsUseCase;

    private final IngestWordUseCase ingestWordUseCase;

    WordController(GetAllWordsUseCase getAllWordsUseCase, IngestWordUseCase ingestWordUseCase) {
        this.getAllWordsUseCase = getAllWordsUseCase;
        this.ingestWordUseCase = ingestWordUseCase;
    }

    @PostMapping
    public String saveWord(@RequestBody String word) {
        IngestWordUseCaseResponse useCaseResponse = ingestWordUseCase.ingestWord(new IngestWordUseCaseRequest(word));
        return useCaseResponse.wordId();
    }

    @GetMapping
    public List<String> getAllWords() {
        return getAllWordsUseCase
                .getAllWords()
                .words()
                .stream()
                .map(Word::getWordId)
                .map(WordId::id)
                .toList();
    }
}
