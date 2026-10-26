package com.rehan.spendsmart.transaction;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(Long id) {
        super("Transaction with ID " + id + " was not found");
    }
}
