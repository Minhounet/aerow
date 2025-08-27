package com.aerow.training.day2and3.configuration.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Point d'entrée pour les webservices, lancer le main ou sinon ./gradlew bootRun
 */
@SpringBootApplication
public class Application {

    // Utiliser le petit triangle pour démarrer Spring Boot
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
