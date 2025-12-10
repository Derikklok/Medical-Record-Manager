# 🚑 Medical Record Manager (Master)

[![Maven](https://img.shields.io/badge/Maven-3.9+-blue)](https://maven.apache.org/)
[![Java](https://img.shields.io/badge/Java-17%2B-teal)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-lightgrey)](./LICENSE)
[![Build Status](https://img.shields.io/badge/build-passing-brightgreen)](#)  

A Spring Boot REST API to centralize medical institution operations (patients, doctors, appointments, diagnoses, medicines, organizations, access accounts). Provides CRUD endpoints, service-layer business logic and a clean layered architecture.

Quick icons: 🩺 Patients | 👨‍⚕️ Doctors | 📅 Appointments | 💊 Medicines | 🏥 Organizations

## Highlights
- Clean Controller → Service → Repository layering
- Ready for local development and deployment
- Database-agnostic (JDBC); example config for Neon (Postgres)
- Basic authentication endpoints included for doctors/patients/access accounts (extend with Spring Security for production)

## Tech stack
- Java 17+
- Spring Boot (Web, Data JPA)
- Maven
- PostgreSQL (Neon) / H2 for local quick dev
- Optional: IntelliJ IDEA

## Repo layout
- src/main/java/com/cura/Master — app entry + subpackages:
  - Controller, Service, Repository, Entity, dto
- src/main/resources — application.properties / profiles

## Neon (Postgres) — minimal config
Neon provides a Postgres connection URI. Set these environment variables (recommended) or add to application-prod.properties:

Example (application.properties or application-prod.yml):
```
spring.datasource.url=jdbc:postgresql://<NEON_HOST>:5432/<DB_NAME>
spring.datasource.username=<NEON_USER>
spring.datasource.password=<NEON_PASSWORD>
spring.datasource.hikari.maximum-pool-size=10
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQL10Dialect
```
Or set a single DATABASE_URL and parse it in your runtime env if preferred. Keep credentials secret; use Neon roles / connection strings and rotate them.

## Getting started (local, H2 quick)
1. Clone:
   ```
   git clone https://github.com/Derikklok/Medical-Record-Manager.git
   cd Medical-Record-Manager
   ```
2. For quick dev, use H2 (example in application.properties):
   ```
   spring.datasource.url=jdbc:h2:mem:meddb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.h2.console.enabled=true
   ```
3. Build & run:
   ```
   mvn clean package
   mvn spring-boot:run
   ```
   or run com.cura.Master.MasterApplication from your IDE.

Base URL: http://localhost:8080

## Common endpoints (verify exact mappings in controllers)
- Patients
  - POST /api/patients/register
  - POST /api/patients/login
  - GET /api/patients/search?query={q}
- Doctors
  - POST /api/doctors/register
  - POST /api/doctors/login
  - GET /api/doctors
- Appointments
  - POST /api/appointments
  - GET /api/appointments/{id}
  - GET /api/appointments/organization/{organizationName}
  - PATCH /api/appointments/{id}/status
- Diagnoses
  - POST /api/diagnoses
  - GET /api/diagnoses/by-organization?organizationName={name}
- Medicines
  - POST /api/medicines/add
  - GET /api/medicines?organizationName={name}
- Organizations
  - POST /api/organizations/create
  - GET /api/organizations/by-owner/{username}
- Access accounts
  - POST /api/access-accounts/create
  - POST /api/access-accounts/login
  - GET /api/access-accounts?organizationName={o}&ownerUsername={u}

Example cURL (create patient):
```
curl -X POST http://localhost:8080/api/patients/register \
  -H "Content-Type: application/json" \
  -d '{"username":"jdoe","firstName":"John","lastName":"Doe","password":"secret","dob":"1990-01-01"}'
```

Login example:
```
curl -X POST http://localhost:8080/api/patients/login \
  -H "Content-Type: application/json" \
  -d '{"username":"jdoe","password":"secret"}'
```

## Testing
Run tests:
```
mvn test
```

## Development notes & tips
- Confirm controller RequestMapping values when integrating.
- Add Spring Security and JWT for production authentication/authorization.
- Use Spring profiles: application-dev.yml (H2), application-prod.yml (Neon/Postgres).
- Use migrations (Flyway/Liquibase) for stable schema management in prod.

## Deployment
- Ensure environment variables for DB connection are set.
- Use a dedicated connection role for app access on Neon.
- Expose only necessary ports and enable HTTPS in front of app.

## Contributing
- Fork → branch → PR with clear description.
- Follow existing patterns and add tests for new features.


