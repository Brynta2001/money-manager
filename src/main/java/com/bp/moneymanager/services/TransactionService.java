package com.bp.moneymanager.services;

import com.bp.moneymanager.exceptions.NotEnoughBalance;
import com.bp.moneymanager.exceptions.NotFoundException;
import com.bp.moneymanager.models.Transaction;
import com.bp.moneymanager.repositories.AccountRepository;
import com.bp.moneymanager.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction create(Transaction transaction) {
        if (transaction.getAmount() <= 0) {
            if (transaction.getAmount() > -transaction.getAccount().getInitialBalance()) {
                throw new NotEnoughBalance("Not enough balance");
            }
        }
        // Update balance
        transaction.getAccount().setInitialBalance(transaction.getAccount().getInitialBalance() + transaction.getAmount());
        return transactionRepository.save(transaction);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new NotFoundException("Transaction not found"));
    }

    public Transaction update(Long id, Transaction transaction) {
        Transaction transactionToUpdate = this.findById(id);
        transaction.setId(transactionToUpdate.getId());
        return transactionRepository.save(transaction);
    }

    public Transaction delete(Long id) {
        Transaction transaction = this.findById(id);
        transactionRepository.deleteById(id);
        return transaction;
    }
}
