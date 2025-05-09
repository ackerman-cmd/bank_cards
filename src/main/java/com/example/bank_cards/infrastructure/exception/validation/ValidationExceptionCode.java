package com.example.bank_cards.infrastructure.exception.validation;

import lombok.Getter;

@Getter
public enum ValidationExceptionCode {
    ACCESS_DENIED("Доступ запрещен"),
    ;
    final String value;

    ValidationExceptionCode(String value) {
        this.value = value;
    }
}
