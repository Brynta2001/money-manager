package com.bp.moneymanager.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person{

    private String password;

    private Boolean status;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

    public Client() {
    }

    public Client(String password, Boolean status, List<Account> accounts) {
        super();
        this.password = password;
        this.status = status;
        this.accounts = accounts;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
