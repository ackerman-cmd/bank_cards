package com.example.bank_cards.controller.auth.dto;

import com.example.bank_cards.entity.user.Role;

public record AuthCredentials(
        String userName,
        String password,
        String email,
        Role role
) { 

}
