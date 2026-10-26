# SpendSmart

A personal finance tracking REST API built with Java and Spring Boot. SpendSmart helps users record income and expenses, organise transactions, and calculate their overall financial balance.

## Features

- Create, view, update, and delete transactions
- Categorise income and expenses
- Filter transactions by type or category
- Calculate total income, total expenses, and balance
- Validate incoming data and handle API errors
- Persist transaction records using Spring Data JPA and H2

## Tech Stack

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA and Hibernate
- H2 Database
- Jakarta Bean Validation
- Maven and JUnit

## Getting Started

1. Install JDK 17 or newer.
2. Clone this repository.
3. Open the project in IntelliJ IDEA and allow Maven to load dependencies.
4. Run `SpendSmartApplication.java`, or run `mvn spring-boot:run` in the terminal.
5. The API will run at `http://localhost:8080`.

## API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/transactions` | Retrieve all transactions |
| GET | `/api/transactions/{id}` | Retrieve one transaction |
| POST | `/api/transactions` | Create a transaction |
| PUT | `/api/transactions/{id}` | Update a transaction |
| DELETE | `/api/transactions/{id}` | Delete a transaction |
| GET | `/api/transactions/summary` | Calculate financial totals |

Transactions can also be filtered using `?type=EXPENSE` or `?category=FOOD`.

## Example Request

Send a POST request to `/api/transactions` with this JSON body:

```json
{
  "amount": 12.50,
  "type": "EXPENSE",
  "category": "FOOD",
  "description": "Lunch",
  "transactionDate": "2026-10-26"
}
```

## Project Structure

- **Controller:** Handles HTTP requests and responses.
- **Service:** Contains transaction operations and financial calculations.
- **Repository:** Manages database access through Spring Data JPA.
- **Entity:** Represents transaction records in the database.
- **Validation and exception handling:** Helps manage invalid requests and missing transactions.

## Future Improvements

- Add user authentication
- Introduce monthly spending reports
- Add integration tests
- Build a web dashboard

*This project is intended for learning and demonstration purposes, not for storing real financial data.*