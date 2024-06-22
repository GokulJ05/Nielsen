package com.nielsen.data.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopperproduct")
public class ShopperProduct {
    @Id
    @Column(name = "shopper_id")
    private String shopperId;

    @ElementCollection
    @CollectionTable(name = "shelf", joinColumns = @JoinColumn(name = "shopper_id"))
    private List<ShelfItem> shelf;

    public String getShopperId() {
        return shopperId;
    }

    public void setShopperId(String shopperId) {
        this.shopperId = shopperId;
    }

    public List<ShelfItem> getShelf() {
        return shelf;
    }

    public void setShelf(List<ShelfItem> shelf) {
        this.shelf = shelf;
    }

}



