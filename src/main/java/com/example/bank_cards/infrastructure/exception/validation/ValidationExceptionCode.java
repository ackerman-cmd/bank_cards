package com.example.bank_cards.infrastructure.exception.validation;

public enum ValidationExceptionCode {
    ACCESS_DENIED("Доступ запрещен"),
    ;
    final String value;

    ValidationExceptionCode(String value) {
        this.value = value;
    }
}
