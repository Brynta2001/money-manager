package com.bp.moneymanager.controllers;

import com.bp.moneymanager.dto.AccountRequestDto;
import com.bp.moneymanager.mapper.AccountMapper;
import com.bp.moneymanager.models.Account;
import com.bp.moneymanager.services.AccountService;
import com.bp.moneymanager.services.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<Account> create(@Valid @RequestBody AccountRequestDto accountRequestDto) {
        Account account = accountMapper.toAccount(accountRequestDto);
        account.setClient(clientService.findById(accountRequestDto.getClientId()));
        return new ResponseEntity<>(accountService.create(account), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        return new ResponseEntity<>(accountService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> findById(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> update(@PathVariable Long id, @Valid @RequestBody AccountRequestDto accountRequestDto) {
        Account account = accountMapper.toAccount(accountRequestDto);
        account.setClient(clientService.findById(accountRequestDto.getClientId()));
        return new ResponseEntity<>(accountService.update(id, account), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Account> delete(@PathVariable Long id) {
        return new ResponseEntity<>(accountService.delete(id), HttpStatus.OK);
    }
}
