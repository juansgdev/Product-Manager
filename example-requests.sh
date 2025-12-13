#!/bin/bash

echo -e "Criando produto 1:"
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira Eletrolux", "preco": 3590.97, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}'

echo -e "\n\nCriando produto 2:"
curl -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Iphone", "preco": 10199.99, "marca": "Apple", "descricao": "Celular RUIM e CARO!"}'

echo -e "\n\nGET produtos:"
curl -X GET http://localhost:8080/products

echo -e "\n\nPUT no produto no produto 2:"
curl -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "nome": "Iphone", "preco": 90199.99, "marca": "Apple", "descricao": "Celular RUIM e CARO!"}'

echo -e "\n\nGET PRODUTOS:"
curl -X GET http://localhost:8080/products

echo -e "\n\nGET pelo id 2:"
curl -X GET http://localhost:8080/products/2

echo -e "\n\nDELETE no id 1:"
curl -X DELETE http://localhost:8080/products/1

echo -e "\n\nGET produtos:"
curl -X GET http://localhost:8080/products
