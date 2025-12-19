package com.techsolutions.productmanager.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.techsolutions.productmanager.domain.ProductStatus;
import com.techsolutions.productmanager.dto.ProductDTO;
import com.techsolutions.productmanager.dto.ProductUpdateRequestDTO;
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

    public List<Product> searchByName (String nome) {
        List<Product> search = productRepository.findByNomeContainingIgnoreCaseAndStatus(nome, ProductStatus.ACTIVE);
        if (search.size() < 1) {throw new EntityNotFoundException("Nenhuma correspondência para: " + nome);}
        return search;
    }

    public List<Product> searchByMarca (String marca) {
        List<Product> search = productRepository.findByMarcaContainingIgnoreCaseAndStatus(marca, ProductStatus.ACTIVE);
        if (search.size() < 1) {throw new EntityNotFoundException("Nenhuma correspondência para: " + marca);}
        return search;
    }

    public Product createProduct (ProductDTO newProduct) {
        Product product = new Product(newProduct);
        if (product.getStatus() != ProductStatus.ACTIVE || product.getId() != null) {
            throw new IllegalArgumentException("Produto inválido!");
        } 
        return productRepository.save(product);
    }
    
    public Product updateProduct (ProductUpdateRequestDTO updatedProduct) {
        Product product =  new Product(updatedProduct);
        try {
            if (product.getId() == null || product.getStatus() == ProductStatus.INACTIVE) { 
                throw new IllegalArgumentException("Produto inválido!");  
            } 
            findProduct(product.getId());
            return productRepository.save(product);
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
