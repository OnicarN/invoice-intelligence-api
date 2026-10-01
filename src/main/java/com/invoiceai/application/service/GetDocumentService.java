package com.invoiceai.application.service;

import com.invoiceai.application.usecase.GetDocumentUseCase;
import com.invoiceai.domain.exception.DocumentNotFoundException;
import com.invoiceai.domain.model.Document;
import com.invoiceai.domain.port.DocumentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GetDocumentService implements GetDocumentUseCase {

    private final DocumentRepository documentRepository;

    public GetDocumentService(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public Document getById(UUID id) {
        return documentRepository.findById(id)
                .orElseThrow(() ->  new DocumentNotFoundException(id));
    }
}