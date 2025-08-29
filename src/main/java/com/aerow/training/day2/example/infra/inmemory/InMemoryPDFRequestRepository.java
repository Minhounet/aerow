package com.aerow.training.day2.example.infra.inmemory;

import com.aerow.training.day2.example.core.domain.PDFRequest;
import com.aerow.training.day2.example.core.usecase.repository.PDFRequestRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPDFRequestRepository implements PDFRequestRepository {

    final List<PDFRequest> documents = new ArrayList<>();

    @Override
    public String save(PDFRequest pdfRequest) {
        documents.add(pdfRequest);
        return pdfRequest.getId();
    }
}
