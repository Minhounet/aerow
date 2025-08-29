package com.aerow.training.day2and3.core.domain;

import java.util.Objects;

/**
 * Ceci est un mot, à vous de l'enrichir avec ce qui est demandé
 */
public class Word {

    private final WordId wordId;

    private final String word;

    private int wordLength;

    Word(WordId wordId,  String word) {
        this.wordId = wordId;
        this.word = word;
        this.wordLength = word.length();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return Objects.equals(wordId, word1.wordId) && Objects.equals(word, word1.word) && Objects.equals(wordLength, word1.wordLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wordId, word, wordLength);
    }

    public static Word from(String wordId, String word) {
        return new Word(new WordId(wordId), word);
    }

    public int getWordLength() {
        return wordLength;
    }

    public void setWordLength(int wordLength) {
        this.wordLength = wordLength;
    }
}
