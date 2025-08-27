package com.aerow.training.day2and3.configuration.spring.configuration;

import com.aerow.training.day2.example.core.usecase.service.IdGenerator;
import com.aerow.training.day2and3.core.usecase.DefaultGetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.DefaultIngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.GetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;
import com.aerow.training.day2and3.infra.generator.IPSSIGeneratorId;
import com.aerow.training.day2and3.infra.inmemory.InMemoryWordRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * C'est le profil par défaut avec tout "en mémoire".
 * Si vous avez fini, vous pouvez utiliser {@link YourAmazingConfiguration} et faire
 * votre propre implémentation de {@link com.aerow.training.day2and3.core.usecase.service.IdGenerator} et
 * de {@link WordRepository}.
 */
@Configuration
@Profile("default")
public class WordConfiguration {

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
        return new InMemoryWordRepository();
    }

    @Bean
    IdGenerator getIdGenerator() {
        return new IPSSIGeneratorId();
    }

}
