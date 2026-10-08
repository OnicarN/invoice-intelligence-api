package com.invoiceai.presentation.dto;

import jakarta.validation.constraints.NotBlank;

public class CreateDocumentRequest {

    @NotBlank
    private String fileName;

    @NotBlank
    private String fileType;

    @NotBlank
    private String storagePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getStoragePath() {
        return storagePath;
    }

    public void setStoragePath(String storagePath) {
        this.storagePath = storagePath;
    }
}