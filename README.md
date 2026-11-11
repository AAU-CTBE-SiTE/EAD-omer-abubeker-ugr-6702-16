# Restaurant Ordering System

A REST API built with Spring Boot to manage restaurant orders and demonstrate Aspect-Oriented Programming (AOP).

## Project Overview

This project demonstrates how to build a simple restaurant ordering system using Spring Boot. It allows users to create, retrieve, update, and delete orders through REST API endpoints.

It also demonstrates AOP concepts through logging and performance monitoring.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring AOP
- Maven
- ArrayList (in-memory storage)

## Features

### Order Management (CRUD)

- Create a new restaurant order.
- Retrieve all orders.
- Retrieve an order by ID.
- Update an existing order.
- Delete an order.

### Aspect-Oriented Programming (AOP)

**1. Logging Aspect**

Uses `@Before` advice to log service method execution before an order operation runs.

**2. Performance Aspect**

Uses `@Around` advice to measure and display the execution time of service methods.

## Project Structure

```text
src/main/java/com/example/restaurantorderingsystem/
│
├── aspect/
│   ├── LoggingAspect.java
│   └── PerformanceAspect.java
│
├── controller/
│   └── OrderController.java
│
├── model/
│   └── Order.java
│
├── service/
│   └── OrderService.java
│
└── RestaurantOrderingSystemApplication.java
```

## API Endpoints

Base URL: `http://localhost:8080/api/orders`

| Method | Endpoint | Description |
| ------ | ------ | ------ |
| POST | `/api/orders` | Create an order |
| GET | `/api/orders` | Get all orders |
| GET | `/api/orders/{id}` | Get an order by ID |
| PUT | `/api/orders/{id}` | Update an order |
| DELETE | `/api/orders/{id}` | Delete an order |

## Example Request

**POST** `/api/orders`

```json
{
  "customerName": "Omer",
  "foodName": "Burger",
  "quantity": 2,
  "totalPrice": 1000,
  "status": "PENDING"
}
```

## Running the Project

1. Clone the repository.
2. Open the project in IntelliJ IDEA.
3. Allow Maven to download the dependencies.
4. Run `RestaurantOrderingSystemApplication.java`.
5. Test the API using Thunder Client or Postman.

## AOP Console Output

Example output when an order operation is executed:

```text
AOP LOG: Executing method: createOrder
PERFORMANCE: createOrder executed in 1.25 ms
```

## Storage

The application uses an in-memory `ArrayList` to store orders. Data is temporary and will be lost when the application restarts.

## Author

Omer Abubeker

## Academic Project

Aspect-Oriented Programming (AOP) – Lab 5

Addis Ababa University

College of Technology and Built Environment
