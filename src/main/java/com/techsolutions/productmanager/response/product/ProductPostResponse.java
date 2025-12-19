package com.techsolutions.productmanager.response.product;

import com.techsolutions.productmanager.dto.ProductDTO;
import com.techsolutions.productmanager.entity.Product;

public record ProductPostResponse (String message, ProductDTO product) {
    public ProductPostResponse (Product product) {
        this("Produto criado com sucesso!", new ProductDTO(product));
    }
}
