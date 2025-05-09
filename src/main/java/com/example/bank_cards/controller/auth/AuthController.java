package com.example.bank_cards.controller.auth;


import com.example.bank_cards.controller.auth.dto.AuthCredentials;
import com.example.bank_cards.controller.auth.dto.JwtTokenResponse;
import com.example.bank_cards.controller.auth.dto.LoginCredentials;
import com.example.bank_cards.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public JwtTokenResponse register(@RequestBody AuthCredentials authCredentials) {
        return authService.register(authCredentials);
    }

    @PostMapping("/login")
    public JwtTokenResponse login(@RequestBody LoginCredentials loginCredentials) {
        return authService.login(loginCredentials);
    }


}
