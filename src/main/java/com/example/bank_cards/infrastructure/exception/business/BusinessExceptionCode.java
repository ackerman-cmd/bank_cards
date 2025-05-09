package com.example.bank_cards.infrastructure.exception.business;

import lombok.Getter;

@Getter
public enum BusinessExceptionCode {
    USER_NOT_FOUND("Пользователь не найден"),
    USER_ALREADY_EXIST("Пользователь уже существует"),
    ROLE_NOT_FOUND("Роль не найдена"),
    ;

    final String value;

    BusinessExceptionCode(String value) {
        this.value = value;
    }
}
