package com.nielsen.data.service;

import com.nielsen.data.model.ShopperProduct;
import com.nielsen.data.repository.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopperProductService {

    @Autowired
    private ShopperProductRepository repository;

    public ShopperProduct saveShopperProduct(ShopperProduct shopperProduct) {
        return repository.save(shopperProduct);
    }

    public ShopperProduct getShopperProductById(String shopperId) {
        return repository.findById(shopperId).orElse(null);
    }
}

