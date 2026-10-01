package com.invoiceai.presentation.controller;

import com.invoiceai.application.usecase.CreateDocumentUseCase;
import com.invoiceai.application.usecase.GetDocumentUseCase;
import com.invoiceai.domain.model.Document;
import com.invoiceai.presentation.dto.CreateDocumentRequest;
import com.invoiceai.presentation.dto.DocumentResponse;

import jakarta.validation.Valid;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/documents")
public class DocumentController {

    private final CreateDocumentUseCase createDocumentUseCase;
    private final GetDocumentUseCase getDocumentUseCase;

    public DocumentController(
            CreateDocumentUseCase createDocumentUseCase,
            GetDocumentUseCase getDocumentUseCase
    ) {
        this.createDocumentUseCase = createDocumentUseCase;
        this.getDocumentUseCase = getDocumentUseCase;
    }

    @PostMapping
    public ResponseEntity<DocumentResponse> createDocument(
            @Valid @RequestBody CreateDocumentRequest request
    ) {

        Document document = new Document(
                null,
                request.getUserId(),
                request.getFileName(),
                request.getFileType(),
                request.getStoragePath(),
                null,
                null
        );

        Document createdDocument = createDocumentUseCase.create(document);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(createdDocument));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentResponse> getDocument(@PathVariable UUID id) {

        Document document = getDocumentUseCase.getById(id);

        return ResponseEntity.ok(toResponse(document));
    }

    private DocumentResponse toResponse(Document document) {
        return new DocumentResponse(
                document.getId(),
                document.getUserId(),
                document.getFileName(),
                document.getFileType(),
                document.getStatus(),
                document.getCreatedAt()
        );
    }
}