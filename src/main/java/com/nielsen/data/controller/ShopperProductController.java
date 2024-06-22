package com.nielsen.data.controller;

import com.nielsen.data.model.ShopperProduct;
import com.nielsen.data.service.ShopperProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/shopper-products")
public class ShopperProductController {

    @Autowired
    private ShopperProductService service;

    @PostMapping
    public ShopperProduct saveShopperProduct(@RequestBody ShopperProduct shopperProduct) {
        return service.saveShopperProduct(shopperProduct);
    }

    @GetMapping("/{shopperId}")
    public ShopperProduct getShopperProductById(@PathVariable String shopperId) {
        return service.getShopperProductById(shopperId);
    }
}

