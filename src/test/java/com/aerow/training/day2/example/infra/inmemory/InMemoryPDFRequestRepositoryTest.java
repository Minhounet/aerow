package com.aerow.training.day2.example.infra.inmemory;

import com.aerow.training.day2.example.core.domain.PDFRequest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryPDFRequestRepositoryTest {

    private final InMemoryPDFRequestRepository repository = new InMemoryPDFRequestRepository();

    @Test
    void should_return_request_id_after_save() {
        String actual = repository.save(new PDFRequest("kebabId", "filename", null));
        assertEquals("kebabId", actual);
    }

    @Test
    void should_save_request_in_memory() {
        PDFRequest pdfRequest = new PDFRequest("kebabId", "filename", null);
        repository.save(pdfRequest);
        assertTrue(repository.documents.contains(pdfRequest));
    }
}