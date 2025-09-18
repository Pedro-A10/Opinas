# 📊 Opinas

**Opinas** é uma aplicação desenvolvida em **Java com Spring Boot** que permite a criação de enquetes, votação em opções e visualização dos resultados de forma simples e eficiente.

---

## 🚀 Funcionalidades

- **Gerenciamento de Usuários**: cadastro, listagem e exclusão.  
- **Criação de Enquetes**: qualquer usuário pode criar suas próprias enquetes.    
- **Resultados**: acompanhar as respostas das enquetes.  
- **Segurança**: senhas armazenadas de forma criptografada com Spring Security.  

---

## 📦 Dependências Principais

- `spring-boot-starter-data-jpa` → Persistência de dados com JPA/Hibernate.  
- `spring-boot-starter-security` → Autenticação e autorização.  
- `spring-boot-starter-validation` → Validação de dados com annotations (`@NotNull`, `@Size`, etc.).  
- `spring-boot-starter-web` → Criação de APIs REST.  
- `h2` → Banco de dados em memória (testes rápidos).  
- `postgresql` → Driver JDBC para PostgreSQL.  
- `flyway-core` + `flyway-database-postgresql` → Controle de migrations do banco.  
- `lombok` → Redução de código repetitivo (getters, setters, construtores).  
- `spring-boot-devtools` → Hot reload em desenvolvimento.  
- `spring-boot-starter-test` → Testes unitários e de integração.  
- `spring-security-test` → Testes de segurança.  

---

## 🧪 Testando a API com Postman

Você pode testar os endpoints usando o **Postman** ou **cURL**.

---

### 🔹 Usuários

**Criar Usuário**  
`POST http://localhost:8080/usuarios`  
Body (JSON):  
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
  
## 📜 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📝 Versão do Projeto

- **Versão 1.1.0-beta**: Adicionadas configurações de segurança (Spring Security), CORS, documentação da API com Swagger e migração de banco de dados com Flyway.

- 📌 Confira o histórico de mudanças no [CHANGELOG.md](./CHANGELOG.md).


