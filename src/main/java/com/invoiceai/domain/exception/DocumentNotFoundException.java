package com.invoiceai.domain.exception;



import java.util.UUID;


public class DocumentNotFoundException extends RuntimeException {

    public DocumentNotFoundException(UUID id) {
        super("Document not found: " + id);
    }
}