package com.techsolutions.productmanager.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.techsolutions.productmanager.domain.ProductStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "products")
@JsonPropertyOrder({
    "id",
    "nome",
	"preco",
	"marca",
    "descricao",
    "status"
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo nome não pode ser vazio ou nulo!")
    @Size(min = 2, max = 50, message = "Campo nome deve ter entre 2 e 50 caracteres!")
    private String nome;

    @NotNull(message = "Campo preço não pode ser nulo ou vazio!")
    @Positive(message = "Campo preço deve ser positivo!")
    @Digits(integer = 5, fraction = 2)
    private BigDecimal preco;
    
    @NotBlank(message = "Campo marca não pode ser vazio ou nulo!")
    @Size(min = 2, max = 50, message = "Campo marca deve ter entre 2 e 50 caracteres!")
    private String marca;

    @NotBlank(message = "Campo descrição não pode ser vazio ou nulo!")
    @Size(min = 15, max = 300, message = "Campo descrição deve ter entre 15 e 300 caracteres!")
    private String descricao;

    @Enumerated(EnumType.STRING)
    private ProductStatus status = ProductStatus.ACTIVE;

    public Product () {
    }
    
    public Product(Long id, String nome, BigDecimal preco, String marca, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.descricao = descricao;
	}
    
    public Product(String nome, BigDecimal preco, String marca, String descricao) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
		this.descricao = descricao;
	}

    public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public ProductStatus getStatus() {
		return status;
	}

	public void setStatus(ProductStatus status) {
		this.status = status;
	}

}
