package com.techsolutions.productmanager.service;

import org.springframework.stereotype.Service;

import com.techsolutions.productmanager.entity.Product;
import com.techsolutions.productmanager.repository.ProductRepository;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProduct (Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct (Product product) {
        productRepository.save(product);
        re
    }

}
