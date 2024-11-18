package com.bp.moneymanager.exceptions;

public class NotEnoughBalance extends RuntimeException {
    public NotEnoughBalance(String message) {
        super(message);
    }
}
