package com.nielsen.data.service;

import com.nielsen.data.model.ProductMetadata;
import com.nielsen.data.repository.ProductMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductMetadataService {

    @Autowired
    private ProductMetadataRepository repository;

    public ProductMetadata saveProductMetadata(ProductMetadata productMetadata) {
        return repository.save(productMetadata);
    }

    public ProductMetadata getProductMetadataById(String productId) {
        return repository.findById(productId).orElse(null);
    }
}

