package com.aerow.training.day2.example.core.usecase.service;

import com.aerow.training.day2.example.core.domain.PDFRequest;

/**
 * Convert un document en pdf
 */
public interface PDFConverter {

    byte[] convert(PDFRequest request);

}
