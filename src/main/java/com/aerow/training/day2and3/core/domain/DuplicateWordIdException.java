package com.aerow.training.day2and3.core.domain;

public class DuplicateWordIdException extends RuntimeException {

    public DuplicateWordIdException(String wordId) {
        super("word id " + wordId + " already used");
    }
}
