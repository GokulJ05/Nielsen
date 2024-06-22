package com.nielsen.data.repository;

import com.nielsen.data.model.ProductMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, String> {
}

