package com.bp.moneymanager.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class AccountRequestDto {

    @NotBlank(message = "Account type is required")
    @Pattern(regexp = "Ahorros|Corriente", message = "Account type must be Ahorros or Corriente")
    private String accountType;

    @NotNull(message = "Initial balance is required")
    private Double initialBalance;

    @NotNull(message = "Status is required")
    private Boolean status;

    @NotNull(message = "Client id is required")
    private Long clientId;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(Double initialBalance) {
        this.initialBalance = initialBalance;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }
}
