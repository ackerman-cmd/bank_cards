package com.example.bank_cards.entity.user;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN("admin"),
    USER("user");

    String role;

    Role(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return role.toLowerCase();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}
