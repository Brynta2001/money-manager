-- Crear tabla Cliente
CREATE TABLE Clients (
    id BIGSERIAL PRIMARY KEY, -- Unique primary key
    name VARCHAR(100) NOT NULL, -- Attributes from Person
    gender VARCHAR(10) NOT NULL,
    age INT NOT NULL,
    identification VARCHAR(20) UNIQUE NOT NULL, -- Unique identifier
    address VARCHAR(255) NOT NULL,
    phone VARCHAR(15) NOT NULL,
    password VARCHAR(255) NOT NULL, -- Attributes specific to Client
    status BOOLEAN NOT NULL
);

-- Create table Account
CREATE TABLE Accounts (
    account_number BIGSERIAL PRIMARY KEY, -- Unique primary key for accounts
    account_type VARCHAR(15) NOT NULL, -- Valid values for account type
    initial_balance DECIMAL(10, 2) NOT NULL,
    status BOOLEAN NOT NULL,
    client_id BIGINT NOT NULL, -- Relation to Client
    CONSTRAINT fk_account_client FOREIGN KEY (client_id) REFERENCES Clients (id) ON DELETE CASCADE
);

-- Create table Transaction
CREATE TABLE Transactions (
    id BIGSERIAL PRIMARY KEY, -- Unique primary key
    transaction_date TIMESTAMP NOT NULL, -- Date of the transaction
    transaction_type VARCHAR(15) NOT NULL, -- Type of transaction
    amount DECIMAL(10, 2) NOT NULL, -- Amount of the transaction
    balance DECIMAL(10, 2) NOT NULL, -- Balance after the transaction
    account_number BIGINT NOT NULL, -- Relation to Account
    CONSTRAINT fk_transaction_account FOREIGN KEY (account_number) REFERENCES Accounts (account_number) ON DELETE CASCADE
);