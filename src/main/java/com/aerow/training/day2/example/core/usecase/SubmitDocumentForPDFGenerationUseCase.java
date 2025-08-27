package com.aerow.training.day2.example.core.usecase;

/**
 * Notre cas métier pour faire une demande de conversion PDF
 */
public interface SubmitDocumentForPDFGenerationUseCase {

    SubmitDocumentForPDFGenerationResponse submit(SubmitDocumentForPDFGenerationRequest request);

}
