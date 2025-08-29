package com.aerow.training.day2and3.infra.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public final class WordEntity {
    @Id
    private  String id;
    private String word;
    private int length;

    public WordEntity() {
        super();
    }

    WordEntity(String id, String word, int length) {
        this.id = id;
        this.word = word;
        this.length = length;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (WordEntity) obj;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.word, that.word) &&
                this.length == that.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, word, length);
    }

    @Override
    public String toString() {
        return "WordEntity[" +
                "id=" + id + ", " +
                "word=" + word + ", " +
                "length=" + length + ']';
    }

}
