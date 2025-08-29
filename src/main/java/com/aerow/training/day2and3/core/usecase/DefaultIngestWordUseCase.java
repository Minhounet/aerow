package com.aerow.training.day2and3.core.usecase;

import com.aerow.training.day2and3.core.domain.Word;
import com.aerow.training.day2and3.core.domain.WordId;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;
import com.aerow.training.day2and3.core.usecase.service.IdGenerator;

public class DefaultIngestWordUseCase implements IngestWordUseCase {

    private final WordRepository wordRepository;
    private final IdGenerator idGenerator;

    public DefaultIngestWordUseCase(WordRepository wordRepository,  IdGenerator idGenerator) {
        this.wordRepository = wordRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public IngestWordUseCaseResponse ingestWord(IngestWordUseCaseRequest word) {
        String wordId = findFirstUnusedWordId();
        wordRepository.save(Word.from(wordId, word.word()));
        return new IngestWordUseCaseResponse(wordId);
    }

    private String findFirstUnusedWordId() {
        String wordId = idGenerator.generateId();
        while (wordRepository.exists(new WordId(wordId))) {
            wordId = idGenerator.generateId();
        }
        return wordId;
    }
}
