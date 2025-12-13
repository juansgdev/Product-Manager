package com.techsolutions.productmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techsolutions.productmanager.domain.ProductStatus;
import com.techsolutions.productmanager.entity.Product;
import com.techsolutions.productmanager.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    public List<Product> listProducts () {
    	return productRepository.findByStatus(ProductStatus.ACTIVE);
    }

    public Product findProduct (Long id) {
        return productRepository.findByIdAndStatus(id, ProductStatus.ACTIVE)
            .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
    }

    public Product createProduct (Product product) {
        return productRepository.save(product);
    }
    
    public Product updateProduct (Product product) {
    	return productRepository.save(product);
    }
    
    public void deleteProduct (Long id) {
    	try {
			Product product = findProduct(id);
            product.setStatus(ProductStatus.INACTIVE);
            updateProduct(product);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Produto não pode ser deletado ou não existe!");
		}
    }

}
