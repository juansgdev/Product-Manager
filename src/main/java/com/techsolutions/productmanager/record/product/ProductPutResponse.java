package com.techsolutions.productmanager.record.product;

import com.techsolutions.productmanager.entity.Product;

public record ProductPutResponse(String message, Product product) {
    public ProductPutResponse (Product product) {
        this("Produto atualizado com sucesso!", product);
    }
}
