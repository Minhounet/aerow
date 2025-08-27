package com.aerow.training.day2and3.core.usecase.exception;

/**
 * A votre avis ?
 */
public class WordAlreadyExistException extends RuntimeException {
    public WordAlreadyExistException(String word) {
        super("word already exists: " + word);
    }
}
