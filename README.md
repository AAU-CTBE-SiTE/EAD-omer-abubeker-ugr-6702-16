# Library Management System

A RESTful Library Management System built using **Java, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

## Features

- Create new books
- Retrieve all books
- Retrieve a book by ID
- Update book information
- Partially update book information
- Delete books
- Store book records in a MySQL database

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Thunder Client (API testing)

## Project Structure

```text
src/main/java/com/site/librarymanagement/
│
├── controller/
│   └── BookController.java
│
├── model/
│   └── Book.java
│
├── repo/
│   └── BookRepo.java
│
├── service/
│   └── BookService.java
│
└── LibraryManagementApplication.java
```

## Database Configuration

Create a MySQL database named:

```sql
CREATE DATABASE library_management;
```

Configure your database credentials in:

`src/main/resources/application.properties`

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/library_management
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

## Running the Application

On Windows, open the project terminal and run:

```bash
.\mvnw.cmd spring-boot:run
```

The application runs at:

```text
http://localhost:8080
```

## API Endpoints

Base URL: `http://localhost:8080/api/books`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/api/books` | Create a book |
| GET | `/api/books` | Get all books |
| GET | `/api/books/{id}` | Get a book by ID |
| PUT | `/api/books/{id}` | Update a book |
| PATCH | `/api/books/{id}` | Partially update a book |
| DELETE | `/api/books/{id}` | Delete a book |

## Example JSON

```json
{
  "title": "Clean Code",
  "author": "Robert C. Martin",
  "isbn": "9780132350884",
  "category": "Programming",
  "quantity": 10,
  "available": true
}
```

## API Testing

The REST API endpoints can be tested using Thunder Client in Visual Studio Code.

## Author

**Omer Abubeker**
