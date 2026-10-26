# SpendSmart

A personal finance tracking REST API built with Java and Spring Boot. Users can record income and expenses, filter transactions, and retrieve a financial summary.

## Features

- Create, read, update, and delete transactions (CRUD)
- Categorise transactions and distinguish income from expenses
- Filter by transaction type or category
- Calculate total income, total expenses, and current balance
- Validate request data and return useful API errors
- Persist data in an embedded H2 database
- Basic Spring application context test

## Tech stack

- Java 17
- Spring Boot
- Spring Web (REST endpoints)
- Spring Data JPA / Hibernate
- H2 relational database
- Jakarta Bean Validation
- Maven and JUnit

## Run locally

1. Install JDK 17 or newer and IntelliJ IDEA.
2. Open this folder as a Maven project.
3. Allow Maven to download dependencies.
4. Run `SpendSmartApplication.java`, or use a terminal:

   ```bash
   mvn spring-boot:run
   ```

5. The API runs at `http://localhost:8080`.

The database is stored locally in the `data` folder and is excluded from Git.

## API examples

### Create a transaction

`POST /api/transactions`

```json
{
  "amount": 12.50,
  "type": "EXPENSE",
  "category": "FOOD",
  "description": "Lunch",
  "transactionDate": "2026-10-26"
}
```

### Get all transactions

`GET /api/transactions`

### Filter transactions

- `GET /api/transactions?type=EXPENSE`
- `GET /api/transactions?category=FOOD`

### Get one transaction

`GET /api/transactions/1`

### Update a transaction

`PUT /api/transactions/1`

Send a JSON body in the same format as the create example.

### Delete a transaction

`DELETE /api/transactions/1`

### Get financial summary

`GET /api/transactions/summary`

Example response:

```json
{
  "totalIncome": 1800.00,
  "totalExpenses": 240.50,
  "balance": 1559.50
}
```

The values above are illustrative. The summary is calculated from the transactions in your local database.

## Project structure

```text
src/main/java/com/rehan/spendsmart/
├── SpendSmartApplication.java
└── transaction/
    ├── Transaction.java
    ├── TransactionCategory.java
    ├── TransactionType.java
    ├── TransactionRequest.java
    ├── TransactionRepository.java
    ├── TransactionService.java
    ├── TransactionController.java
    ├── TransactionNotFoundException.java
    └── ApiExceptionHandler.java
```

## Architecture

- **Controller:** Receives HTTP requests and returns API responses.
- **Service:** Holds application logic, including the summary calculation.
- **Repository:** Uses Spring Data JPA to read and write transaction records.
- **Entity:** Maps a Java object to a database table.
- **Request record:** Defines and validates incoming transaction data.
- **Exception handler:** Converts common errors into consistent JSON responses.

## Future improvements

- Add user accounts and authentication
- Add monthly summaries and pagination
- Replace H2 with MySQL for a shared deployment
- Add integration tests for transaction endpoints
- Build a small web dashboard

## Important note

This is a learning project and is not intended to store real financial or banking data.
