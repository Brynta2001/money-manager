# Money Manager

## Description

This is a simple money manager app that allows you to keep track of your expenses and incomes. You can add, edit and delete transactions. The app also provides a summary of your total balance, total expenses and total incomes.
This is the result of the resolution of the challenge proposed by the challenge for BP.

## Technologies

- SpringBoot
- Java
- PostgreSQL

## How to run

1. Clone this repository
2. Start the container with the PostgreSQL database:
    ```
    docker-compose up -d
    ```
3. Install the dependencies.
4. Run the application.

## Usage

1. Access the application at `http://localhost:8080`.
2. Add a new client.
3. Add a new account.
4. Add a new transaction.

## API

The API has the following endpoints:

### Clients
- `GET /clients`: Get all clients.
- `GET /clients/{id}`: Get a client by id.
- `POST /clients`: Create a new client.
- `PUT /clients/{id}`: Update a client by id.
- `DELETE /clients/{id}`: Delete a client by id.

### Accounts
- `GET /accounts`: Get all accounts.
- `GET /accounts/{id}`: Get an account by id.
- `POST /accounts`: Create a new account.
- `PUT /accounts/{id}`: Update an account by id.
- `DELETE /accounts/{id}`: Delete an account by id.

### Transactions
- `GET /transactions`: Get all transactions.
- `GET /transactions/{id}`: Get a transaction by id.
- `POST /transactions`: Create a new transaction.
- `PUT /transactions/{id}`: Update a transaction by id.
- `DELETE /transactions/{id}`: Delete a transaction by id.

## Postman Collection

The postman collection is available in the `postman` folder.
This is a collection with the requests to the API.

## Author

Bryan Tapia

