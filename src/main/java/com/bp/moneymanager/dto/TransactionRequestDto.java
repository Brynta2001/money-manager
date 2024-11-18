package com.bp.moneymanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class TransactionRequestDto {
    @NotBlank(message = "Transaction date is required")
    private String transactionDate;

    @NotBlank(message = "Transaction type is required")
    @Pattern(regexp = "Deposito|Retiro", message = "Transaction type must be Deposito or Retiro")
    private String transactionType;

    @NotNull(message = "Amount is required")
    private Double amount;

    @NotNull(message = "Balance is required")
    private Double balance;

    @NotNull(message = "Account number is required")
    private Long accountNumber;

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
}
