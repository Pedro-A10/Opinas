# 📜 Changelog (PT/EN)
Todas as mudanças notáveis neste projeto serão documentadas aqui.

O formato segue [Keep a Changelog](https://keepachangelog.com/pt-BR/1.0.0/),
e este projeto adota [Versionamento Semântico](https://semver.org/lang/pt-BR/).

---

## [1.3.0-beta] - 23-09-2025
### ✨ Atualização / Updated
- Criação de **Exceções** personalizadas / Custom **Exceptions** created.
- Implementação do **GlobalExceptionHandler** para centralizar tratamentos / Implementation of **GlobalExceptionHandler** to centralize error handling.

---

## [1.2.1-beta] - 22-09-2025
### ✨ Atualização / Updated
- Padronização da nomenclatura de métodos e endpoints para inglês / Standardization of method and endpoint naming to English:

```
listarEnquetes        → listPolls()          / GET /polls
criarEnquete          → createPoll()         / POST /polls
cadastrarUsuario      → registerUser()       / POST /users/register
criarOpcao            → createOption()       / POST /polls/{pollId}/options
votar                 → vote()               / POST /polls/{pollId}/votes
```

---

## [1.2.0-beta] - 09-19-2025
### ✨ Adicionado / Added
- Adição da camada **DTO/Mapper** para separar entidades de modelos de dados / Added **DTO/Mapper** layer to separate entities from DTOs.
- Ajustes na arquitetura para maior desacoplamento e clareza do código / Refactored architecture for better decoupling and clarity.
    
---

## [1.1.0-beta] - 09-16-2025
### ✨ Adicionado / Added
- Configuração de **Segurança** com Spring Security / **Security** configuration with Spring Security.
- Configuração de **CORS** / **CORS** configuration.
- Integração do **Swagger** para documentação da API / **Swagger** integration for API documentation.
- **Flyway** para versionamento e migração do banco de dados / **Flyway** for database versioning and migration.

---

## [1.0.0-beta] - 09-12-2025
### ✨ Adicionado / Added
- CRUD inicial de **usuários**, **enquetes**, **opções** e **vote** / Initial CRUD for **users**, **polls**, **options**, and **votes**.
