package com.aerow.training.day2.example.core.usecase;

import java.util.Arrays;
import java.util.Objects;

/**
 * Représente une demande de conversion PDF
 */
public record SubmitDocumentForPDFGenerationRequest(String filename, byte[] document) {
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        SubmitDocumentForPDFGenerationRequest that = (SubmitDocumentForPDFGenerationRequest) o;
        return Objects.equals(filename, that.filename) && Objects.deepEquals(document, that.document);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filename, Arrays.hashCode(document));
    }

    @Override
    public String toString() {
        return "SubmitDocumentForPDFGenerationRequest{" +
                "filename='" + filename + '\'' +
                ", document=" + Arrays.toString(document) +
                '}';
    }
}
