package com.invoiceai.infrastucture.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DocumentJpaRepository extends JpaRepository<DocumentEntity, UUID> {
}