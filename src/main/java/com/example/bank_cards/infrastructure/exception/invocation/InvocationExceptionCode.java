package com.example.bank_cards.infrastructure.exception.invocation;

public enum InvocationExceptionCode {
    USER_NOT_FOUND("Ошибка при поиске пользователя"),
    ;
    final String value;

    InvocationExceptionCode(String value) {
        this.value = value;
    }
}
