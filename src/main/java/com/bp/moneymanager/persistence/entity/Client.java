package com.bp.moneymanager.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "clients")
public class Client extends Person{

    private String password;

    private Boolean status;

    @OneToMany(mappedBy = "client")
    private List<Account> accounts;

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
}
