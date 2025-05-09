package com.example.bank_cards.infrastructure.exception.business;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }
}
