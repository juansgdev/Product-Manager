package com.techsolutions.productmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Product Manager", version = "1",
description = "API que provê as operações create, read, update e delete(CRUD) para a entidade <b>product</b>.\nO recurso product é persistido em banco de dados relacional MySQL e possui as seguintes propriedades: \n\nid: auto incremental e chave primária;</br>nome: campo alfanúmerico que define o nome do produto;</br>preco(preço): valor de ponto flutuante, define o preço do produto;</br>marca: campo alfanúmerico que indica a marca do produto;</br>descricao(descrição): campo alfanúmerico, define a descrição e as características do produto;</br>status: enum com os valores ACTIVE e INACTIVE, de uso interno da API para implementar soft delete."
))
public class ProductmanagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductmanagerApplication.class, args);
	}

}
