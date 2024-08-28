package com.dto;

import com.entity.Product;
import com.entity.Quantity;

public class ProductRequestDTO {

    private Product product;
    private Quantity quantity;

    // Getters and Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }
}
