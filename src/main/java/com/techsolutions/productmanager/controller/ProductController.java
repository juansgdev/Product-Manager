package com.techsolutions.productmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsolutions.productmanager.entity.Product;
import com.techsolutions.productmanager.record.product.ProductPostResponse;
import com.techsolutions.productmanager.record.product.ProductPutResponse;
import com.techsolutions.productmanager.service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts () {
        return productService.listProducts();
    }

    @GetMapping("{id}")
    public Product getProduct (@PathVariable("id") Long id) {
        return productService.findProduct(id);
    }

    @PostMapping
    public ProductPostResponse createProduct (@Valid @RequestBody Product product) {
        return new ProductPostResponse(productService.createProduct(product));
    }

    @PutMapping
    public ProductPutResponse updateProduct (@Valid @RequestBody Product product) {
        return new ProductPutResponse(productService.updateProduct(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity
            .status(HttpStatus.OK)
            .body("Produto removido com sucesso!");
    }

}
