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
        if (product.getStatus() == ProductStatus.ACTIVE && product.getId() == null) {
            return productRepository.save(product);
        } else {
            throw new IllegalArgumentException("Produto inválido!");
        }
    }
    
    public Product updateProduct (Product product) {
        try {
            if (product.getId() != null && product.getStatus() == ProductStatus.ACTIVE) {
                findProduct(product.getId());
                return productRepository.save(product);
            } else {
                throw new IllegalArgumentException("Produto inválido!");
            }
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("Produto não encontrado para atualizar!");
        }        
    }
    
    public void deleteProduct (Long id) {
    	try {
			Product product = findProduct(id);
            product.setStatus(ProductStatus.INACTIVE);
            productRepository.save(product);
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Produto não encontrado para deletar!");
		}
    }

}
