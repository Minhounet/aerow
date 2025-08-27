package com.aerow.training.day2and3.configuration.spring.controller;

import com.aerow.training.day2and3.core.usecase.GetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCase;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @GetMapping
    public List<String> getAllWords() {
        return List.of("IPSSI kings");
    }
}
