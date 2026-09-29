package com.invoiceai.domain.port;

import com.invoiceai.domain.model.Document;

import java.util.Optional;
import java.util.UUID;

public interface DocumentRepository {

    Document save(Document document);

    Optional<Document> findById(UUID id);
}