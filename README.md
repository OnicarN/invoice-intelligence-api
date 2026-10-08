# Invoice Intelligence API

Backend REST desarrollado con Java y Spring Boot para la gestión y procesamiento inteligente de facturas.

El objetivo del proyecto es construir una API capaz de recibir documentos de facturas, almacenarlos, procesarlos mediante IA y extraer información estructurada de ellos.

> 🚧 **Project status:** In development

## Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Docker
- Flyway
- JPA / Hibernate
- Maven
- OpenAPI / Swagger
- JUnit 5
- Testcontainers

## Architecture

The project follows a pragmatic Clean Architecture approach.

```text
presentation
     ↓
application
     ↓
domain
     ↑
infrastructure
