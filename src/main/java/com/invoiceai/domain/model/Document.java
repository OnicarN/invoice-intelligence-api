package com.invoiceai.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Document {

    private UUID id;
    private UUID userId;
    private String fileName;
    private String fileType;
    private String storagePath;
    private DocumentStatus status;
    private LocalDateTime createdAt;

    public Document() {
    }

    public Document(
            UUID id,
            UUID userId,
            String fileName,
            String fileType,
            String storagePath,
            DocumentStatus status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.userId = userId;
        this.fileName = fileName;
        this.fileType = fileType;
        this.storagePath = storagePath;
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

    public String getStoragePath() {
        return storagePath;
    }

    public DocumentStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setStatus(DocumentStatus status) {
        this.status = status;
    }
}