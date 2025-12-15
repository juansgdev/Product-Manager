#!/bin/bash

echo -e "Criando produto 1:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira Eletrolux", "preco": 3590.97, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}'

echo -e "\n\nCriando produto 2:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Iphone", "preco": 10199.99, "marca": "Apple", "descricao": "Celular RUIM e CARO!"}'

echo -e "\n\nGET produtos:"
curl -i -X GET http://localhost:8080/products

echo -e "\n\nPUT no produto no produto 2:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "nome": "Iphone", "preco": 90199.99, "marca": "Apple", "descricao": "Celular RUIM e CARO!"}'

echo -e "\n\nGET PRODUTOS:"
curl -i -X GET http://localhost:8080/products

echo -e "\n\nGET pelo id 2:"
curl -i -X GET http://localhost:8080/products/2

echo -e "\n\nDELETE no id 1:"
curl -i -X DELETE http://localhost:8080/products/1

echo -e "\n\nGET produtos:"
curl -i -X GET http://localhost:8080/products

echo -e "\n\nGET produtos passando string no url param [ ERRO ]:"
curl -i http://localhost:8080/products/abc

echo -e "\n\nGET produtos por id com id de produto que não existe [ ERRO ]:"
curl -i http://localhost:8080/products/80

echo -e "\n\nGET produtos com url param nulo [ ERRO ]:"
curl -i http://localhost:8080/products/

echo -e "\n\nDELETE produtos com string no url param [ ERRO ]:"
curl -i -X DELETE http://localhost:8080/products/abc

echo -e "\n\nDELETE produtos com id de produto que não existe [ ERRO ]:"
curl -i -X DELETE http://localhost:8080/products/80

echo -e "\n\nDELETE produtos com url param nulo [ ERRO ]:"
curl -i -X DELETE http://localhost:8080/products/

echo -e "\n\nPOST produtos com corpo inválido 1, passando mensagem [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"message": "alguma mensagem", {"nome": "Geladeira Eletrolux", "preco": 3590.97, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}}'

echo -e "\n\nPOST produtos com corpo inválido 2, valor decimal mal formatado [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira Eletrolux", "preco": 3590.9847, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}'

echo -e "\n\nPOST produtos com corpo inválido 3, 2 campos faltando [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"preco": 3590.97, "marca": "Eletrolux"}'

echo -e "\n\nPOST produtos com corpo inválido 4, com id [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "nome": "Geladeira", "preco": 3590.98, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}'

echo -e "\n\nPOST produtos com corpo inválido 5, com campo a mais [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira Eletrolux", "preco": 3590.98, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!", "avaliacao": "5 estrelas"}'

echo -e "\n\nPOST produtos com corpo inválido 6, sem body [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json"

echo -e "\n\nPOST produtos com corpo inválido 7, sem body e content-type [ ERRO ]:"
curl -i -X POST http://localhost:8080/products

echo -e "\n\nPOST produtos com corpo inválido 8, passando html [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: text/html" -d '<h1>TEXTO</h1>'

echo -e "\n\nPOST produtos com corpo inválido 10, passando status INACTIVE [ ERRO ]:"
curl -i -X POST http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira Eletrolux", "preco": 3590.97, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!", "status": "INACTIVE"}'

echo -e "\n\nPUT produtos com corpo inválido 1, passando mensagem [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"message": "alguma mensagem", {"id": 2, "nome": "GELADEIRA", "preco": 3590.97, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}}'

echo -e "\n\nPUT produtos com corpo inválido 2, valor decimal mal formatado [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "nome": "Geladeira", "preco": 3590.9847, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}'

echo -e "\n\nPUT produtos com corpo inválido 3, 2 campos faltando [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "preco": 3590.97, "marca": "Eletrolux"}'

echo -e "\n\nPUT produtos com corpo inválido 4, sem id [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira", "preco": 3590.98, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!"}'

echo -e "\n\nPUT produtos com corpo inválido 5, com campo a mais [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "nome": "Geladeira Eletrolux", "preco": 3590.98, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!", "avaliacao": "5 estrelas"}'

echo -e "\n\nPUT produtos com corpo inválido 6, sem body [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json"

echo -e "\n\nPUT produtos com corpo inválido 7, sem body e content-type [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products

echo -e "\n\nPUT produtos com corpo inválido 8, passando html [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: text/html" -d '<h1>TEXTO</h1>'

echo -e "\n\nPUT produtos com corpo inválido 9, passando status INACTIVE [ ERRO ]:"
curl -i -X PUT http://localhost:8080/products -H "Content-Type: application/json" -d '{"nome": "Geladeira Eletrolux", "preco": 3590.97, "marca": "Eletrolux", "descricao": "Geladeira muito boa E CARA!", "status": "INACTIVE"}'

echo -e "\n\nRequisição para método não implementado [ ERRO ]:"
curl -i -X PATCH http://localhost:8080/products -H "Content-Type: application/json" -d '{"id": 2, "marca": "Xiaomi"}'

echo -e "\n\nRequisição para rota raiz [ ERRO ]:"
curl -i http://localhost:8080

echo -e "\n\nRequisição para rota não implementada [ ERRO ]:"
curl -i http://localhost:8080/contacts

echo -e "\n\nRequisição para rota númerica [ ERRO ]:"
curl -i http://localhost:8080/123456

echo -e "\n\nRequisição para rota não implementada com url param nulo [ ERRO ]:"
curl -i -X DELETE http://localhost:8080/contacts/

echo -e "\n\nRequisição para rota não implementada com url param númerico [ ERRO ]:"
curl -i -X DELETE http://localhost:8080/contacts/123456

echo -e "\n\nRequisição para rota não implementada com url param string [ ERRO ]:"
curl -i -X DELETE http://localhost:8080/contacts/abc
