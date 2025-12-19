package com.techsolutions.productmanager.response.product;

import com.techsolutions.productmanager.dto.ProductDTO;
import com.techsolutions.productmanager.entity.Product;

public record ProductPutResponse(String message, ProductDTO product) {
    public ProductPutResponse (Product product) {
        this("Produto atualizado com sucesso!", new ProductDTO(product));
    }
}
