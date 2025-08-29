package com.aerow.training.day2and3.configuration.spring.controller;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.usecase.*;
import io.vavr.control.Try;
import org.springframework.http.ResponseEntity;
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

    private final GetAllWordsUseCase getAllWordsUseCase;

    private final IngestWordUseCase ingestWordUseCase;

    WordController(GetAllWordsUseCase getAllWordsUseCase, IngestWordUseCase ingestWordUseCase) {
        this.getAllWordsUseCase = getAllWordsUseCase;
        this.ingestWordUseCase = ingestWordUseCase;
    }

    @PostMapping
    public ResponseEntity<String> saveWord(@RequestBody String word) {
        Try<IngestWordUseCaseResponse> useCaseResponseAttempt = Try.of(() -> ingestWordUseCase.ingestWord(new IngestWordUseCaseRequest(word)));
        return useCaseResponseAttempt.fold(t -> ResponseEntity.internalServerError().build(),
                response -> ResponseEntity.ok(response.wordId()));

    }

    @GetMapping
    public ResponseEntity<Object> getAllWords() {
        Try<GetAllWordsUseCaseResponse> userCaseAttempt = Try.of(getAllWordsUseCase::getAllWords);
        return userCaseAttempt.fold(t -> ResponseEntity.internalServerError().build(),
                response -> ResponseEntity.ok(mapWords(response.words())));

    }

    private List<WordEntry> mapWords(List<Word> words) {
        return words.stream()
                .map(word -> new WordEntry(word.getWordId().id(), word.getWord(), word.getWordLength()))
                .toList();
    }
}
