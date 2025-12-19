package com.techsolutions.productmanager.response.product;

public record ProductDeleteResponse(String message) {
    public ProductDeleteResponse () {
        this("Produto removido com sucesso!");
    }
}
