package com.invoiceai.presentation.dto;

import com.invoiceai.domain.model.DocumentStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class DocumentResponse {

    private UUID id;
    private UUID userId;
    private String fileName;
    private String fileType;
    private DocumentStatus status;
    private LocalDateTime createdAt;

    public DocumentResponse(
            UUID id,
            UUID userId,
            String fileName,
            String fileType,
            DocumentStatus status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.userId = userId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}