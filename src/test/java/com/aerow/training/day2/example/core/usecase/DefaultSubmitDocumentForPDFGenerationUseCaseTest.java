package com.aerow.training.day2.example.core.usecase;

import com.aerow.training.day2.example.core.domain.PDFRequest;
import com.aerow.training.day2.example.core.usecase.repository.PDFRequestRepository;
import com.aerow.training.day2.example.core.usecase.service.IdGenerator;
import com.aerow.training.day2.example.core.usecase.service.PDFConverter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DefaultSubmitDocumentForPDFGenerationUseCaseTest {

    @Mock
    private IdGenerator idGenerator;

    @Mock
    private PDFConverter pdfConverter;

    @Mock
    private PDFRequestRepository pdfRequestRepository;

    @InjectMocks
    private DefaultSubmitDocumentForPDFGenerationUseCase submitDocumentForPDFGenerationUseCase;

    @Test
    void should_return_unique_request_id() {
        when(idGenerator.generateId()).thenReturn("kebabId");
        SubmitDocumentForPDFGenerationResponse actual = submitDocumentForPDFGenerationUseCase.submit(
                new SubmitDocumentForPDFGenerationRequest("any", "kebabId".getBytes())
        );
        assertEquals(new SubmitDocumentForPDFGenerationResponse("kebabId"), actual);
    }

    @Test
    void should_save_request_in_repository() {
        when(idGenerator.generateId()).thenReturn("kebabId");
        byte[] originalContent = "sauce".getBytes();
        submitDocumentForPDFGenerationUseCase.submit(
                new SubmitDocumentForPDFGenerationRequest("kebabFilename", originalContent)
        );

        ArgumentMatcher<? extends PDFRequest> pdfMatcher = request ->
                "kebabId".equals(request.getId())
                        && "kebabFilename".equals(request.getFilename())
                        && Arrays.equals(originalContent, request.getOriginalContent());
        verify(pdfRequestRepository).save(argThat(pdfMatcher));
    }
}