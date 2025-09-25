# Opinas  
Opinas é uma aplicação desenvolvida em Java com Spring Boot que permite a criação de enquetes, votação em opções e visualização dos resultados de forma simples e eficiente.

---

Funcionalidades
- **Gerenciamento de Usuários**: cadastro, listagem e exclusão.
- **Criação de Enquetes**: qualquer usuário pode criar as suas próprias enquetes.
- **Resultados**: acompanhar as respostas das enquetes.
- **Segurança**: senhas armazenadas de forma criptografada com Spring Security.

---

Dependências Principais
- `spring-boot-starter-data-jpa` → Persistência de dados com JPA/Hibernate.
- `spring-boot-starter-security` → Autenticação e autorização.
- `spring-boot-starter-validation` → Validação de dados com annotations (@NotNull, @Size, etc.).
- `spring-boot-starter-web` → Criação de APIs REST.
- `h2` → Banco de dados em memória (testes rápidos).
- `postgresql` → Driver JDBC para PostgreSQL.
- `flyway-core + flyway-database-postgresql` → Controle de migrations do banco.
- `lombok` → Redução de código repetitivo (getters, setters, construtores).
- `spring-boot-devtools` → Hot reload em desenvolvimento.
- `spring-boot-starter-test` → Testes unitários e de integração.
- `spring-security-test` → Testes de segurança.

---

Testando a API com Postman  
Você pode testar os endpoints usando o Postman ou cURL.
- **Coleção Postman pronta para importar:** [📂 Opinas Collection](docs/postman/Opinas.postman_collection.json)
- **Variável de ambiente recomendada:** `baseUrl = http://localhost:8080`

---

 Exemplos de JSON  
Exemplos de payloads para os endpoints podem ser encontrados em: [📄 JSON Examples](docs/json-examples/)

- `user.json` → Payload para criar usuário
- `poll.json` → Payload para criar enquete
- `option.json` → Payload para criar opção
- `vote.json` → Payload para registrar voto

---

 Licença  
Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

 Versão do Projeto  
1.4.0-beta: Adição de autenticação (DTOs de login e registro), pacote e configuração de segurança finalizados. Correção de erros gerais. / Authentication added (Login and Register DTOs), security package and configuration completed. General bug fixes.

Confira o histórico de mudanças no [CHANGELOG.md](CHANGELOG.md).
