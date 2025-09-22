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

## 📝 Jsons

Exemplos de JSON para a API podem ser encontrados [aqui](docs/json-examples/).

---
  
## 📜 Licença
Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

## 📝 Versão do Projeto

- **1.2.1-beta**: Padronização da nomenclatura de métodos e endpoints para inglês / Standardization of method and endpoint naming to English:

- 📌 Confira o histórico de mudanças no [CHANGELOG.md](./CHANGELOG.md).


