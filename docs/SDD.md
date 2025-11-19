TODO: update app name

# 1. Introduction

## 1.1 Purpose

The purpose of this document is to describe the architecture and design of the IntelliBank Lite system, a web-based banking application that allows users to perform secure banking operations including registration, login, profile management, money transfers, transaction history viewing, and email notifications.

This document serves as a blueprint for developers and provides a foundation for future enhancements.

## 1.2 Scope

* Backend: Spring Boot (Java 17)

* Frontend: React (Vite)

* Database: PostgreSQL

* Communication: REST APIs

* Deployment: Dockerized environment (local dev and future cloud deployment)

⸻

# 2. High-Level Architecture

## 2.1 System Overview

IntelliBank Lite follows a client-server architecture:
    [Frontend (React)] <----HTTP/HTTPS----> [Backend (Spring Boot)] <----SQL----> [PostgreSQL DB]

* Frontend: Handles user interface, form input, and API calls
* Backend: Handles business logic, authentication, authorization, and database interactions
* Database: Stores users, accounts, transactions, and audit logs

## 2.2 Component Diagram
Frontend (React)
 ├─ LoginPage.jsx
 ├─ DashboardPage.jsx
 ├─ AccountList.jsx
 ├─ TransferPage.jsx
 └─ TransactionHistory.jsx
Backend (Spring Boot)
 ├─ Controller Layer (REST endpoints)
 ├─ Service Layer (business logic)
 ├─ Repository Layer (database access)
 ├─ Entity Layer (DB models)
 ├─ DTO Layer (data transfer objects)
 ├─ Security Layer (JWT + role checks)
 ├─ Scheduler Layer (optional background tasks)
 └─ Utils / Mapper / Exception Handling
Database (PostgreSQL)
 ├─ Users
 ├─ Accounts
 ├─ Transactions
 ├─ AuditLogs
 └─ Other supporting tables

 ## 2.3 Technology Stack

| Layer            | Technology                          |
|------------------|-------------------------------------|
| **Backend**      | Java 17, Spring Boot 3            |
| **Frontend**     | React, Vite, TailwindCSS          |
| **Database**     | PostgreSQL                        |
| **API Docs**     | Swagger / OpenAPI                 |
| **Security**     | JWT, Spring Security              |
| **Containerization** | Docker, Docker Compose        |

TODO
## 2.4 Architecture Diagram

# 3. Database Design

TODO
## 3.1 ER Diagram
![Banking App ER Diagram](docs/images/)

## 3.2 Notes
* Use UUID or bigint for IDs.

* Sensitive data such as passwords should be stored as hashes (Bcrypt)

# 4 Low-level Design 

## 4.1 Layered architecture 

Controller (DTO objects are used) -> Service (Converts DTO to entity) -> Repository (Entities are used) -> Database

* Controller: Handles HTTP requests, calls service layer.

* Service: Business logic, validation, and transaction management.

* Repository: CRUD operations with Spring Data JPA.

* Entity: Database mappings using JPA.

* DTO: Objects for API communication (to avoid exposing entities directly).

TODO
## 4.2 Class Diagram

TODO: money transfer
## 4.3 Sequence Diagram 

## 4.4 Notes
TODO: Use Swagger to automatically generate frontend types that match DTOs

# 5. API Design

## 5.1 Authentication 
| Endpoint                        | Method | Request                          | Response                | Notes                     |
|--------------------------------|--------|---------------------------------|-------------------------|---------------------------|
| `/api/v1/auth/register`        | POST   | `{username, email, password}`  | 201 Created / Error    | Creates new user         |
| `/api/v1/auth/login`           | POST   | `{username, password}`         | 200 OK + JWT / 401     | Returns JWT              |
| `/api/v1/auth/forgot-password` | POST   | `{email}`                      | 200 OK                 | Sends reset email        |
| `/api/v1/auth/reset-password`  | POST   | `{token, newPassword}`         | 200 OK / Error         | Updates password         |

## 5.2 Accounts
| Endpoint                  | Method | Request | Response | Notes                |
|---------------------------|--------|---------|----------|-----------------------|
| `/api/v1/accounts`       | GET    | JWT     | List     | Fetch user accounts  |
| `/api/v1/accounts/{id}`  | GET    | JWT     | Account  | Fetch single account |

## 5.3 Transactions
| Endpoint                  | Method | Request                                   | Response            | Notes                        |
|---------------------------|--------|-------------------------------------------|---------------------|-----------------------------|
| `/api/v1/transactions`   | GET    | JWT                                       | List               | User’s transaction history |
| `/api/v1/transfers`      | POST   | `{fromAccountId, toAccountId, amount}`    | Transaction status | Initiates transfer         |

## 5.4 Notes
* All endpoints requie JWT authentication exceot registration and login.

* Responses standardized with {status, message, data}.

* Errors use meaningful HTTP codes (400, 401, 403, 404, 500).

# 6. Security Design

* Passwords hashed with Bcrypt.

* JWT for authentication, short expiry (10 min) with refresh token. 

* Role-based access (User/Admin) in Spring Security.

* CORS (cross origin resource sharing) enabled for frontend requests.

* Input validation on all requests.

* No logging of sensitive data.

# 7. Logging & Error Handling

* use SLF4J + Logback for backend logging. 

* Log incoming requests (controller entrypoint)

* Log errors and exceptions

* Log critical actions (login, transfer)

* Return standardized error responses 
{"status": "error", 
"message" : "Insufficient Balance"}

# 8. Scheduler 

* Use Spring Scheduler (@Scheduled) tasks for:
    - Expiring old password reset tokens 
    - Reset login counters (if implemented)
    - Send scheduled notifications

# 9. Non-functional considerations

| Requirement     | Notes                                                      |
|-----------------|-----------------------------------------------------------|
| **Performance** | Backend should handle ~100 concurrent users in Phase 1   |
| **Scalability** | *Dockerized deployment allows easy future scaling*         |
| **Maintainability** | Layered architecture supports future feature addition |
| **Security**    | JWT, hashed passwords, input validation, minimal logs    |
| **Usability**   | Frontend React app will consume REST APIs                |
| **Portability** | Spring Boot + Docker ensures portability across OS/environments |

# 10. Project Folder structure
banking-app/
├── backend/
│   ├── src/main/java/com/app/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   ├── entity/
│   │   ├── dto/
│   │   ├── security/
│   │   ├── scheduler/
│   │   ├── utils/
│   │   └── exception/
│   ├── src/main/resources/
│   │   ├── application.yml
│   │   ├── schema.sql
│   │   └── data.sql
│   └── Dockerfile
├── frontend/
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── api/
│   │   ├── router/
│   │   ├── store/
│   │   └── utils/
│   └── Dockerfile
└── docker-compose.yml
 

# 11. Notes / Future Enhancements

* Phase 1: Core functionality

* Phase 2: Add structured logging, schedulers, audit log enhancements

* Phase 3: Cloud deployment, CI/CD, container orchestration

* Add unit tests and integration tests