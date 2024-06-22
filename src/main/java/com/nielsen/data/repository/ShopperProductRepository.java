package com.nielsen.data.repository;

import com.nielsen.data.model.ShopperProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperProductRepository extends JpaRepository<ShopperProduct, String> {
}

