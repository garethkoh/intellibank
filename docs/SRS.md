# Software Requirements Specification (SRS)  
## **Project: Banking app**  
**Version:** 1.0  
**Date:** *14 November 2025*
---
# 1. Introduction
## 1.1 Purpose
The purpose of *Banking app* is to provide a secure, modular, backend-driven digital banking system for educational and demonstration purposes. The system enables users to authenticate, manage accounts, transfer funds securely, view transaction history, and receive notifications. This SRS outlines functional and non-functional requirements for the backend system built using Spring Boot and Postgres.
## 1.2 Scope
Banking app will provide:
- User authentication using JWT  
- Account management  
- Secure money transfers  
- Transaction history features  
- Admin user management  
- Email notifications  
- Scheduled background tasks  
The system exposes REST APIs to a frontend client developed using React.
## 1.3 Definitions, Acronyms, and Abbreviations
- **API** – Application Programming Interface  
- **JWT** – JSON Web Token  
- **OTP** – One-Time Password  
- **REST** – Representational State Transfer  
- **RBAC** – Role-Based Access Control  
## 1.4 Overview 
This SRS details:
- System features (3)
- External interfaces (4)
- Non-functional requirements (5)
- Database requirements (6) 
- System architecture (7)
---
# 2. Overall Description
## 2.1 Product Perspective
Banking app is a client-server web application consisting of:
- React based frontend that provides the user interface
- Spring boot backend service that handles business logic, authentication, authorization, and exposes API endpoints that are consumed by the frontend
- Postgres database provides persistent data storage 
- SMTP/email service  
- Spring Scheduler
  
## 2.2 Product Functions
Major features:
- User registration & login  
- Password reset & management  
- Profile/account management  
- Fund transfers  
- Transaction history  
- Email notifications  
- Admin panel APIs  
- Scheduled jobs (interest calculation, cleanup)  
## 2.3 User Classes and Characteristics
| User Class | Description | Permissions |
|-----------|-------------|-------------|
| **Customer** | Standard banking user | Manage own account, transfer funds, view transactions |
| **Admin** | System admin | Manage users, roles, logs, account state |
## 2.4 Operating Environment
- Java 17+  
- Spring Boot 3+  
- Postgres 14+  
- SMTP-compatible email service  
- Deployed locally or on cloud  
## 2.5 Design and Implementation Constraints
- JWT authentication must be used  
- Layered architecture required  
- Sensitive data must be encrypted or hashed  
- All transfers must follow ACID properties  
## 2.6 User Documentation
- Swagger/OpenAPI documentation  
- Developer README  
- Deployment guide  
## 2.7 Assumptions and Dependencies
- Valid email is required  
- Environment variables configured correctly  
- Internet available for email sending  
---
# 3. System Features
## 3.1 User Registration
### Functional Requirements
- **FR-1.1:** User can register using email, username, password.  
- **FR-1.2:** Email must be validated and unique.
- **FR-1.4:** Username must be unique.
- **FR-1.3:** Password must meet strength minimum.  
---
## 3.2 User Authentication (JWT)
### Functional Requirements
- **FR-2.1:** User logs in using email/username + password.  
- **FR-2.2:** JWT is generated upon login.  
- **FR-2.3:** JWT must expire.  
- **FR-2.4:** Excessive failed logins may trigger temporary lockout.  
---
## 3.3 Password Management
### Functional Requirements
- **FR-3.1:** User can change password using old password.  
- **FR-3.2:** User can request password reset via email.  
- **FR-3.3:** OTP must expire after configurable time.  
---
## 3.4 Account Management
### Functional Requirements
- **FR-4.1:** User can update personal info (email, phone, address, username NOT allowed).  
- **FR-4.2:** User can view account balance.  
- **FR-4.3:** 2FA via email OTP.   
---
## 3.5 Money Transfer
### Functional Requirements
- **FR-5.1:** User can transfer money to other users.  
- **FR-5.2:** System validates sufficient balance.  
- **FR-5.3:** System enforces daily transfer limits.  
- **FR-5.4:** Transfer must be ACID-compliant.  
- **FR-5.5:** System sends notification after transfer.  
---
## 3.6 Transaction History
### Functional Requirements
- **FR-6.1:** User may view all account transactions.  
- **FR-6.2:** User may filter transactions by date, type, amount.  
- **FR-6.3:** Pagination required.   
---
## 3.7 Audit Logging
### Functional Requirements
- **FR-7.1:** System logs important actions (login, transfer, profile update).  
- **FR-7.2:** Log data stored in immutable table.  
- **FR-7.3:** Admin can view audit logs.  
---
## 3.8 Scheduled Jobs
### Functional Requirements
- **FR-8.1:** Monthly interest calculation.  
- **FR-8.2:** Inactive accounts auto-locking.  
- **FR-8.3:** Purge expired tokens/OTPs.  
- **FR-8.4:** Generate and email monthly statements.  
---
## 3.9 Admin Panel (Backend APIs)
### Functional Requirements
- **FR-9.1:** Admin can view all users.  
- **FR-9.2:** Admin can lock/unlock accounts.  
- **FR-9.3:** Admin can modify roles.  
- **FR-9.4:** Admin can force password reset.  
- **FR-9.5:** Admin can view audit logs and login attempts.  
---
# 4. External Interface Requirements
## 4.1 User Interfaces
- React user interface
- System shall support cross-origin requests between frontend and backend
## 4.2 API Interfaces
- JSON format  
- Authentication via JWT in `Authorization` header  
- HTTPS recommended  
## 4.3 Hardware Interfaces
None.
## 4.4 Software Interfaces
- Postgres database  
- SMTP server  
- Spring Scheduler (for checking expired tokens)
---
# 5. Non-Functional Requirements
## 5.1 Performance Requirements
- 90% of API responses within 300ms.  
- Minimum 100 concurrent users supported.  
- Scheduled jobs must complete within acceptable time.  
## 5.2 Security Requirements
- Passwords hashed with BCrypt or Argon2.  
- Endpoints protected by JWT except public endpoints.  
- RBAC enforced.  
- Sensitive data excluded from logs.  
## 5.3 Reliability and Availability
- Email sending retries on failure.  
- Scheduled job fault tolerance required.  
- Transaction consistency guaranteed.  
## 5.4 Maintainability
- Must follow layered architecture.  
- Use clear JavaDoc on service methods.  
- Standardized logging formats.  
## 5.5 Portability
- Runs on any system with Java 17+.  
- Must support Docker.  
---
# 6. Database Requirements
## 6.1 Key Tables
- `USERS`  
- `ACCOUNTS`  
- `TRANSACTIONS`  
- `AUDIT_LOG`  
- `OTP_CODES`    
## 6.2 Constraints
- Foreign key relationships enforced.  
- Transaction table stores before/after balance.  
- Audit log is append-only.  
---
# 7. System Architecture (High-Level)
- Controller (REST API Layer)  
- Service Layer (Business Logic)  
- Repository Layer (Database Access)  
- Security Layer (JWT, RBAC)  
- Scheduler Layer  
- Notification Layer  
- Database Layer  
---
# 8. Appendix
- API endpoint listing  
- Sample JSON request/response  
- Glossary