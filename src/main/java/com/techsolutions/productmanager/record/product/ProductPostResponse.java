package com.techsolutions.productmanager.record.product;

import com.techsolutions.productmanager.entity.Product;

public record ProductPostResponse (String message, Product product) {
    public ProductPostResponse (Product product) {
        this("Produto criado com sucesso!", product);
    }
}
