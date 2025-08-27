package com.aerow.training.day2and3.configuration.spring.configuration;

import com.aerow.training.day2.example.core.usecase.service.IdGenerator;
import com.aerow.training.day2and3.core.usecase.DefaultGetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.DefaultIngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.GetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("IPSSI")
public class YourAmazingConfiguration {
    @Bean
    IngestWordUseCase getIngestWordUseCase(WordRepository wordRepository, IdGenerator idGenerator) {
        return new DefaultIngestWordUseCase(wordRepository, idGenerator);
    }

    @Bean
    GetAllWordsUseCase getAllWordsUseCase(WordRepository wordRepository) {
        return new DefaultGetAllWordsUseCase(wordRepository);
    }

    @Bean
    WordRepository getWordRepository() {
        throw new UnsupportedOperationException("Add your own word implementation of Word repository");
    }

    @Bean
    IdGenerator getIdGenerator() {
        throw new UnsupportedOperationException("Add your own id generator of id generator");
    }

}
