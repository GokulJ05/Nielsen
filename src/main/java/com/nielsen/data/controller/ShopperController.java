package com.nielsen.data.controller;


import com.nielsen.data.model.ProductMetadata;
import com.nielsen.data.model.ProductShelf;
import com.nielsen.data.model.ShelfItem;
import com.nielsen.data.service.ProductMetadataService;
import com.nielsen.data.service.ShopperProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/shopper")
public class ShopperController {

    @Autowired
    private ShopperProductService shopperProductService;

    @Autowired
    private ProductMetadataService productMetadataService;

    @GetMapping("/products")
    public List<ProductShelf> getProductsByShopper(
            @RequestParam String shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(required = false, defaultValue = "10") int limit
    ) {

        List<ShelfItem> shelfItems = shopperProductService.getShopperProductById(shopperId)
                .getShelf();

        List<String> productIds = shelfItems
                .stream()
                .map(item -> item.getProductId())
                .collect(Collectors.toList());

        List<ProductMetadata> productMetadata =  productIds.stream()
                .map(productMetadataService::getProductMetadataById)
                .filter(product -> category == null || product.getCategory().equals(category))
                .filter(product -> brand == null || product.getBrand().equals(brand))
                .limit(Math.min(limit, 100))
                .collect(Collectors.toList());

        List<ProductShelf> productShelves = new ArrayList<>();
        for(ProductMetadata productMetadata1 : productMetadata){
            ProductShelf productShelf = new ProductShelf();
            productShelf.setProductId(productMetadata1.getProductId());
            productShelf.setBrand(productMetadata1.getBrand());
            productShelf.setCategory(productMetadata1.getCategory());
            productShelf.setRelevancyScore(shelfItems.stream().filter(s -> s.getProductId().equals(productMetadata1.getProductId())).map(s->s.getRelevancyScore()).findFirst().orElse(null));
            productShelves.add(productShelf);
        }
        return productShelves;
    }
}

