package com.techsolutions.productmanager.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techsolutions.productmanager.dto.ProductDTO;
import com.techsolutions.productmanager.dto.ProductUpdateRequestDTO;
import com.techsolutions.productmanager.response.product.ProductDeleteResponse;
import com.techsolutions.productmanager.response.product.ProductListResponse;
import com.techsolutions.productmanager.response.product.ProductPostResponse;
import com.techsolutions.productmanager.response.product.ProductPutResponse;
import com.techsolutions.productmanager.service.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@RestController
@RequestMapping("/products")
@Validated
@Tag(name = "/products", description = "Endpoint principal da entidade <b>product</b>.")
public class ProductController {
    private ProductService productService;

    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getProducts () {
        return ProductListResponse.mapToList(productService.listProducts());
    }

    @GetMapping("{id}")
    public ProductDTO getProduct (@PathVariable("id") @Positive(message = "Parametro via url inválido!") Long id) {
        return new ProductDTO(productService.findProduct(id));
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<ProductDTO>> searchProductByName (
        @PathVariable("nome")
        @NotBlank(message = "Escreva um nome para buscar!")
        @Size(min = 2, max = 50, message = "Nome para busca deve ter entre 2 e 50 caracteres!")
        String nome
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductListResponse.mapToList(productService.searchByName(nome)));
    }

    @GetMapping("/marca/{marca}")
    public ResponseEntity<List<ProductDTO>> searchProductByBrand (
        @PathVariable("marca")
        @NotBlank(message = "Escreva um marca para buscar!")
        @Size(min = 2, max = 50, message = "Marca para busca deve ter entre 2 e 50 caracteres!")
        String marca
    ) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(ProductListResponse.mapToList(productService.searchByMarca(marca)));
    }

    @PostMapping
    public ResponseEntity<ProductPostResponse> createProduct (@Valid @RequestBody ProductDTO product) {
        ProductPostResponse newProduct = new ProductPostResponse(productService.createProduct(product));
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(newProduct);
    }

    @PutMapping
    public ProductPutResponse updateProduct (@Valid @RequestBody ProductUpdateRequestDTO product) {
        return new ProductPutResponse(productService.updateProduct(product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<ProductDeleteResponse> deleteProduct (@PathVariable @Positive(message = "Parametro via url inválido!") Long id) {
        productService.deleteProduct(id);
        ProductDeleteResponse response = new ProductDeleteResponse();
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(response);
    }

}
