package com.techsolutions.productmanager.service;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
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
    	return productRepository.findAll();
    }

    public Product getProduct (Long id) {
        return productRepository.findById(id)
        		.orElseThrow(() -> new EntityNotFoundException("Produto não encontrado!"));
    }

    public Product createProduct (Product product) {
        return productRepository.save(product);
    }
    
    public Product updateUser (Product product) {
    	return productRepository.save(product);
    }
    
    public void deleteUser (Long id) {
    	try {
			Product product = productRepository.
			
			if (product.getStatus() == ProductStatus.ACTIVE) {
				product.setStatus(ProductStatus.INACTIVE);
				productRepository.save(product);
			}
		} catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Produto não pode ser deletado ou não existe!");
		}
    }

}
