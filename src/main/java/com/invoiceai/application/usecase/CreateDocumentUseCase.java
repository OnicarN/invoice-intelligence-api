package com.invoiceai.application.usecase;

import com.invoiceai.domain.model.Document;

public interface CreateDocumentUseCase {

    Document create(Document document);
}