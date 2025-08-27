package com.aerow.training.day2.example.core.usecase;

import com.aerow.training.day2.example.core.domain.PDFRequest;
import com.aerow.training.day2.example.core.usecase.repository.PDFRequestRepository;
import com.aerow.training.day2.example.core.usecase.service.IdGenerator;
import com.aerow.training.day2.example.core.usecase.service.PDFConverter;

public class DefaultSubmitDocumentForPDFGenerationUseCase implements SubmitDocumentForPDFGenerationUseCase {

    private final PDFRequestRepository pdfRequestRepository;

    private final PDFConverter pdfConverter;

    private final IdGenerator idGenerator;

    public DefaultSubmitDocumentForPDFGenerationUseCase(PDFRequestRepository pdfRequestRepository, PDFConverter pdfConverter, IdGenerator idGenerator) {
        this.pdfRequestRepository = pdfRequestRepository;
        this.pdfConverter = pdfConverter;
        this.idGenerator = idGenerator;
    }

    @Override
    public SubmitDocumentForPDFGenerationResponse submit(SubmitDocumentForPDFGenerationRequest request) {
        // Ecrire toute la logique métier à l'aide de nos amis les interfaces
        String requestId = idGenerator.generateId();
        var pdfRequest = new PDFRequest(requestId, request.filename(), request.document());
        pdfRequestRepository.save(pdfRequest);
        return new SubmitDocumentForPDFGenerationResponse(requestId);
    }
}
