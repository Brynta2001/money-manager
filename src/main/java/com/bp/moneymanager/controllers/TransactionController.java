package com.bp.moneymanager.controllers;

import com.bp.moneymanager.dto.TransactionRequestDto;
import com.bp.moneymanager.mapper.TransactionMapper;
import com.bp.moneymanager.models.Transaction;
import com.bp.moneymanager.services.AccountService;
import com.bp.moneymanager.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<Transaction> create(TransactionRequestDto transactionRequestDto) {
        Transaction transaction = transactionMapper.toTransaction(transactionRequestDto);
        transaction.setAccount(accountService.findById(transactionRequestDto.getAccountNumber()));
        return new ResponseEntity<>(transactionService.create(transaction), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findAll() {
        return new ResponseEntity<>(transactionService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> findById(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Transaction> update(@PathVariable Long id, TransactionRequestDto transactionRequestDto) {
        Transaction transaction = transactionMapper.toTransaction(transactionRequestDto);
        transaction.setAccount(accountService.findById(transactionRequestDto.getAccountNumber()));
        return new ResponseEntity<>(transactionService.update(id, transaction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Transaction> delete(@PathVariable Long id) {
        return new ResponseEntity<>(transactionService.delete(id), HttpStatus.OK);
    }
}
