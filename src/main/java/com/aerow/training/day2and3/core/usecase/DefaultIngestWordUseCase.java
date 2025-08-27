package com.aerow.training.day2and3.core.usecase;

import com.aerow.training.day2.example.core.usecase.service.IdGenerator;
import com.aerow.training.day2and3.core.usecase.exception.IngestWordUseCaseRequest;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;

public class DefaultIngestWordUseCase implements IngestWordUseCase {

    private final WordRepository wordRepository;
    private final IdGenerator idGenerator;

    public DefaultIngestWordUseCase(WordRepository wordRepository,  IdGenerator idGenerator) {
        this.wordRepository = wordRepository;
        this.idGenerator = idGenerator;
    }

    @Override
    public IngestWordUseCaseResponse ingestWord(IngestWordUseCaseRequest word) {
        return new IngestWordUseCaseResponse("hello world");
    }
}
