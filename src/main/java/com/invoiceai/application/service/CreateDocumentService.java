package com.invoiceai.application.service;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.invoiceai.application.usecase.CreateDocumentUseCase;
import com.invoiceai.domain.model.Document;
import com.invoiceai.domain.model.DocumentStatus;
import com.invoiceai.domain.port.DocumentRepository;

@Service 
public class CreateDocumentService implements CreateDocumentUseCase {

    private final DocumentRepository documentRepository;

    public CreateDocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document create(Document document) {
        Document documentToSave = new Document(
            UUID.randomUUID(),
            document.getUserId(),
            document.getFileName(),
            document.getFileType(),
            document.getStoragePath(),
            DocumentStatus.PENDING,
            LocalDateTime.now()
    );

    return documentRepository.save(documentToSave);
    }
}