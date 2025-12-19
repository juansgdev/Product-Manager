package com.techsolutions.productmanager.response.product;

import java.util.List;

import com.techsolutions.productmanager.dto.ProductDTO;
import com.techsolutions.productmanager.entity.Product;

public record ProductListResponse(List<ProductDTO> products) {
    public static List<ProductDTO> mapToList(List<Product> products) {
        return products.stream()
                       .map(ProductDTO::new)
                       .toList();
    }
}
