package com.aerow.training.day2.example.core.usecase.repository;

import com.aerow.training.day2.example.core.domain.PDFRequest;

/**
 * Permet de sauvegarder la demande de conversion quelque part
 */
public interface PDFRequestRepository {

    String save(PDFRequest pdfRequest);
}
