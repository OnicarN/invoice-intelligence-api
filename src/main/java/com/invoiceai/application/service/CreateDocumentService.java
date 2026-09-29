package com.invoiceai.application.service;

import com.invoiceai.application.usecase.CreateDocumentUseCase;
import com.invoiceai.domain.model.Document;
import com.invoiceai.domain.port.DocumentRepository;

public class CreateDocumentService implements CreateDocumentUseCase {

    private final DocumentRepository documentRepository;

    public CreateDocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document create(Document document) {
        return documentRepository.save(document);
    }
}