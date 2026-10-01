package com.invoiceai.application.usecase;

import com.invoiceai.domain.model.Document;

import java.util.UUID;

public interface GetDocumentUseCase {

    Document getById(UUID id);
}