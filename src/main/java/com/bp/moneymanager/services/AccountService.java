package com.bp.moneymanager.services;

import com.bp.moneymanager.exceptions.NotFoundException;
import com.bp.moneymanager.models.Account;
import com.bp.moneymanager.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public Account create(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElseThrow(() -> new NotFoundException("Account not found"));
    }

    public Account update(Long id, Account account) {
        Account accountToUpdate = this.findById(id);
        account.setAccountNumber(accountToUpdate.getAccountNumber());
        return accountRepository.save(account);
    }

    public Account delete(Long id) {
        Account account = this.findById(id);
        accountRepository.deleteById(id);
        return account;
    }
}
