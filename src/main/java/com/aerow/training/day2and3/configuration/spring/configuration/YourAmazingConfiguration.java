package com.aerow.training.day2and3.configuration.spring.configuration;

import com.aerow.training.day2and3.core.usecase.DefaultGetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.DefaultIngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.GetAllWordsUseCase;
import com.aerow.training.day2and3.core.usecase.IngestWordUseCase;
import com.aerow.training.day2and3.core.usecase.repository.WordRepository;
import com.aerow.training.day2and3.core.usecase.service.IdGenerator;
import com.aerow.training.day2and3.infra.generator.IPSSIGeneratorId;
import com.aerow.training.day2and3.infra.jpa.CrudWordRepository;
import com.aerow.training.day2and3.infra.jpa.JpaWordRepository;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Votre configuration spring à vous, il faut lancer sous Intellij avec
 * "-Dspring.profiles.active=IPSSI" (ou en ligne de commande avec ./gradlew bootRun --args='--spring.profiles.active=IPSSI')
 *
 * toute la partie jpa permet de persister en base de données sans "gros travail".
 */
@Configuration
@Profile("IPSSI")
@EnableJpaRepositories(basePackages = "com.aerow.training.day2and3.infra.jpa")
@EntityScan(basePackages = "com.aerow.training.day2and3.infra.jpa")
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
    WordRepository getWordRepository(CrudWordRepository crudWordRepository) {
        return new JpaWordRepository(crudWordRepository);
    }

    @Bean
    IdGenerator getIdGenerator() {
        return new IPSSIGeneratorId();
    }

}
