package com.example.bank_cards.infrastructure.exception.validation;

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
