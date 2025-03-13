# API de Produtos

Esta API permite gerenciar produtos, incluindo criação, leitura, atualização e exclusão (CRUD). Abaixo estão os detalhes dos endpoints disponíveis.

### 1. Criar Produto
- URL: `/api/products`
- Método: `POST`
- Descrição: Cria um novo produto.
- JSON: 
  ```json
  {
    "name": "Produto Exemplo",
    "description": "Descrição do produto exemplo",
    "price": 99.99,
    "quantity": 10,
    "category": "ELECTRONICS"
  }
  ```
  
### 2. Obter Produto por ID
- URL: `/api/products/id/{id}`
- Método:`GET`
- Descrição: Retorna os detalhes de um produto pelo ID.
- Exemplo de Requisição: /api/products/id/1

### 3.  Buscar Produtos pelo Nome
- URL: `/api/products/name/{name}`
- Método: `GET` 
- Descrição: Retorna uma lista de produtos que contenham o nome especificado. 
- Exemplo de Requisição: /api/products/name/Exemplo 

### 4. Buscar Todos os Produtos
- URL: `/api/products`
- Método: `GET`
- Descrição: Retorna uma lista de todos os produtos.

### 5. Atualizar Produto
- URL: `/api/products/{id}`
- Método: `PUT`
- Descrição: Atualiza os detalhes de um produto existente. 
- JSON:

```json
{
"name": "Produto Atualizado",
"description": "Descrição atualizada",
"price": 79.99,
"quantity": 15,
"category": "ELECTRONICS"
}
```

### 6. Deletar Produto
- URL: `/api/products/{id}`
- Método: `DELETE`
- Descrição: Exclui um produto pelo ID.
- Exemplo de Requisição: /api/products/1
