# User Role Management System

## Overview

This project is a simple User Role Management System built with Java, Spring Boot, and H2 in-memory database. It demonstrates a clean architecture for managing users and roles, including user creation, role creation, and assigning roles to users. The project follows best practices for separation of concerns, validation, exception handling, and uses RESTful APIs.

## Features

- Create users with name and email
- Create roles with a role name
- Assign roles to users
- Retrieve user details (including assigned roles)
- Input validation and global exception handling
- In-memory H2 database for easy setup and testing
- OpenAPI/Swagger UI documentation (auto-generated)

## Project Structure

```
src/main/java/com/example/usermanagement/
├── UserManagementApplication.java         # Main Spring Boot application
├── application/                          # Application services
│   ├── UserService.java
│   ├── RoleService.java
│   └── interfaces/
│       ├── UserRepository.java
│       └── RoleRepository.java
├── config/
│   └── BeanConfig.java                   # Spring beans configuration
├── domain/                               # Domain models
│   ├── User.java
│   └── Role.java
└── infrastructure/
		├── controller/                       # REST controllers & DTOs
		│   ├── UserController.java
		│   ├── RoleController.java
		│   ├── CreateUserRequest.java
		│   ├── CreateRoleRequest.java
		│   ├── UserResponse.java
		│   └── GlobalExceptionHandler.java
		└── persistence/                      # JPA entities & repositories
				├── UserJpaEntity.java
				├── RoleJpaEntity.java
				├── UserJpaRepository.java
				├── RoleJpaRepository.java
				├── UserJpaRepositorySpringData.java
				└── RoleJpaRepositorySpringData.java
```

## Technologies Used

- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database (in-memory)
- Spring Validation
- OpenAPI/Swagger (springdoc-openapi)

## Getting Started

### Prerequisites

- Java 17+
- Maven

### Running the Application

1. **Clone the repository:**
   ```
   git clone https://github.com/CodeWithIsmail/User-role-management-system.git
   cd User-role-management-system
   ```
2. **Build and run:**

   ```
   mvn spring-boot:run
   ```

   The application will start on `http://localhost:8080`.

3. **Access H2 Console (for DB inspection):**

   - Visit `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`, Password: `password`

4. **API Documentation (Swagger UI):**
   - Visit `http://localhost:8080/swagger-ui.html` or `/swagger-ui/index.html`

## API Endpoints

### User APIs

- **Create User**

  - `POST /users`
  - Request Body:
    ```json
    {
      "name": "John Doe",
      "email": "john@example.com"
    }
    ```
  - Response: `201 Created` with user ID

- **Get User Details**

  - `GET /users/{id}`
  - Response: User details with assigned roles

- **Assign Role to User**
  - `POST /users/{userId}/assign-role/{roleId}`
  - Response: `200 OK` on success

### Role APIs

- **Create Role**
  - `POST /roles`
  - Request Body:
    ```json
    {
      "roleName": "ADMIN"
    }
    ```
  - Response: `201 Created` with role ID

## Example Usage

1. **Create a Role:**
   - POST `/roles` with `{ "roleName": "ADMIN" }`
2. **Create a User:**
   - POST `/users` with `{ "name": "Alice", "email": "alice@example.com" }`
3. **Assign Role:**
   - POST `/users/{userId}/assign-role/{roleId}`
4. **Get User Details:**
   - GET `/users/{userId}`

## Validation & Error Handling

- All input is validated (e.g., non-empty name/email, valid email format)
- Errors return meaningful messages and appropriate HTTP status codes

## Design & Architecture

- **Layered architecture:** Domain, Application, Infrastructure
- **Repository pattern:** Abstracts persistence logic
- **DTOs:** Used for API requests/responses
- **Global exception handler:** Centralized error responses


## Author & Credits

- Developed by CodeWithIsmail
- For academic purposes (SE 606 Software Design & Analysis course)

---

