package com.techsolutions.productmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techsolutions.productmanager.domain.ProductStatus;
import com.techsolutions.productmanager.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	List<Product> findByStatus(ProductStatus status);

}
