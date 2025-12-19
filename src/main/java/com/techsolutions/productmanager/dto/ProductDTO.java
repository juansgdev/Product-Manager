package com.techsolutions.productmanager.dto;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.techsolutions.productmanager.entity.Product;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@JsonPropertyOrder({
    "nome",
    "preco",
    "marca",
    "descricao"
})
public record ProductDTO(
        @NotBlank(message = "Campo nome não pode ser vazio ou nulo!")
        @Size(min = 2, max = 50, message = "Campo nome deve ter entre 2 e 50 caracteres!")
        String nome, 
        @NotNull(message = "Campo preço não pode ser nulo ou vazio!")
        @Positive(message = "Campo preço deve ser positivo!")
        @Digits(integer = 5, fraction = 2)
        BigDecimal preco, 
        @NotBlank(message = "Campo marca não pode ser vazio ou nulo!")
        @Size(min = 2, max = 50, message = "Campo marca deve ter entre 2 e 50 caracteres!")
        String marca, 
        @NotBlank(message = "Campo descrição não pode ser vazio ou nulo!")
        @Size(min = 15, max = 300, message = "Campo descrição deve ter entre 15 e 300 caracteres!")
        String descricao
) {
    public ProductDTO (Product product) {
        this(product.getNome(), product.getPreco(), product.getMarca(), product.getDescricao());
    }
}
