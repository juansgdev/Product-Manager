package com.techsolutions.productmanager.record.product;

public record ProductDeleteResponse(String message) {
    public ProductDeleteResponse () {
        this("Produto removido com sucesso!");
    }
}
