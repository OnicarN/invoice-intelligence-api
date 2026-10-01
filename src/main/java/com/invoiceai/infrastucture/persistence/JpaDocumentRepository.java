package com.invoiceai.infrastucture.persistence;

import com.invoiceai.domain.model.Document;
import com.invoiceai.domain.port.DocumentRepository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public class JpaDocumentRepository implements DocumentRepository {

    private final DocumentJpaRepository documentJpaRepository;

    public JpaDocumentRepository(DocumentJpaRepository documentJpaRepository) {
        this.documentJpaRepository = documentJpaRepository;
    }

    @Override
    public Document save(Document document) {
        DocumentEntity entity = new DocumentEntity();

        entity.setId(document.getId());
        entity.setUserId(document.getUserId());
        entity.setFileName(document.getFileName());
        entity.setFileType(document.getFileType());
        entity.setStoragePath(document.getStoragePath());
        entity.setStatus(document.getStatus());
        entity.setCreatedAt(document.getCreatedAt());

        DocumentEntity savedEntity = documentJpaRepository.save(entity);

        return toDomain(savedEntity);
    }

    @Override
    public Optional<Document> findById(UUID id) {
        return documentJpaRepository.findById(id)
                .map(this::toDomain);
    }

    private Document toDomain(DocumentEntity entity) {
        return new Document(
                entity.getId(),
                entity.getUserId(),
                entity.getFileName(),
                entity.getFileType(),
                entity.getStoragePath(),
                entity.getStatus(),
                entity.getCreatedAt()
        );
    }
}