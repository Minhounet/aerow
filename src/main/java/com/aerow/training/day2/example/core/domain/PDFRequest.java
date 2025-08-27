package com.aerow.training.day2.example.core.domain;

public class PDFRequest {

    private String id;
    private String filename;
    private byte[] originalContent;

    private byte[] pdfContent;

    public PDFRequest(String id, String filename, byte[] originalContent) {
        this.id = id;
        this.filename = filename;
        this.originalContent = originalContent;
    }

    public String getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getOriginalContent() {
        return originalContent;
    }

    public byte[] getPdfContent() {
        return pdfContent;
    }

    public void setPdfContent(byte[] pdfContent) {
        this.pdfContent = pdfContent;
    }
}
