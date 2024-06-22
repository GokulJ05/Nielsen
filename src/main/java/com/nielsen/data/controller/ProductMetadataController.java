package com.nielsen.data.controller;

import com.nielsen.data.model.ProductMetadata;
import com.nielsen.data.service.ProductMetadataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product-metadata")
public class ProductMetadataController {

    @Autowired
    private ProductMetadataService service;

    @PostMapping
    public ProductMetadata saveProductMetadata(@RequestBody ProductMetadata productMetadata) {
        return service.saveProductMetadata(productMetadata);
    }

    @GetMapping("/{productId}")
    public ProductMetadata getProductMetadataById(@PathVariable String productId) {
        return service.getProductMetadataById(productId);
    }
}
