# Opinas

**Opinas** é uma aplicação desenvolvida em Java que permite coletar, analisar e visualizar opiniões públicas de forma eficiente.

## 🚀 Funcionalidades

- **Coleta de Dados**: Captura de opiniões de diversas fontes, como redes sociais e formulários online.
- **Análise de Sentimentos**: Processamento de texto para identificar sentimentos predominantes (positivo, negativo, neutro)..

## 📦 Dependências (Bibliotecas usadas)

- **spring-boot-starter-data-jpa** → Suporte a JPA/Hibernate para persistência de dados.
- **spring-boot-starter-security** → Autenticação e autorização da aplicação.
- **spring-boot-starter-validation** → Validação de dados via annotations (`@NotNull`, `@Size`, etc.).
- **spring-boot-starter-web** → Criação de APIs REST e aplicações web.
- **h2** → Banco de dados em memória, útil para testes rápidos.
- **postgresql** → Driver JDBC para PostgreSQL.
- **flyway-core** → Gerenciamento de migrations do banco de dados.
- **flyway-database-postgresql** → Suporte do Flyway para PostgreSQL.
- **lombok** → Reduz código repetitivo (getters, setters, construtores automáticos).
- **spring-boot-devtools** → Hot reload em desenvolvimento (somente runtime).
- **spring-boot-starter-test** → Ferramentas para testes unitários e integração.
- **spring-security-test** → Ferramentas para testes de segurança (Spring Security).

## 🧪 Testando a API com Postman

Você pode usar o **Postman** para testar os endpoints da API sem precisar de uma interface web.

### Endpoints de Usuários

1. **Criar Usuário**  
   - **POST** `http://localhost:8080/usuarios`  
   - **Body (JSON):**
     ```json
     {
       "nome": "Pedro",
       "email": "pedro@email.com",
       "password": "SerialLain1221"
     }
     ```
   - **Observação:** A senha fornecida é **criptografada automaticamente** pelo sistema antes de ser armazenada no banco de dados, garantindo segurança dos dados.
   - **Resposta esperada:**  
     ```json
     {
       "id": 1,
       "nome": "Pedro",
       "email": "pedro@email.com"
     }
     ```

### Endpoints de Enquetes

1. **Criar Enquete Simples**  
   - **POST** `http://localhost:8080/enquetes`  
   - **Body (JSON):**
     ```json
     {
       "titulo": "Qual linguagem você prefere?",
       "mensagem": "Vote na sua favorita!",
       "comentarios": "Primeira enquete de teste"
     }
     ```

2. **Criar Enquete com Opções**  
   - **POST** `http://localhost:8080/enquetes`  
   - **Body (JSON):**
     ```json
     {
       "titulo": "Qual sua linguagem favorita?",
       "mensagem": "Vote na que você mais gosta!",
       "usuario": { "id": 2 },
       "opcoes": [
         { "texto": "Java" },
         { "texto": "Python" },
         { "texto": "C" },
         { "texto": "Go" }
       ]
     }
     ```

3. **Listar Enquetes**  
   - **GET** `http://localhost:8080/enquetes`

4. **Atualizar Enquete**  
   - **PUT** `http://localhost:8080/enquetes/{id}`

5. **Deletar Enquete**  
   - **DELETE** `http://localhost:8080/enquetes/{id}`

## 📝 Versão do Projeto

- **Versão  1.0.0-beta**: Atualmente o repositório contém apenas o CRUD inicial de usuários, enquetes, opções e votos sendo a base do projeto.
