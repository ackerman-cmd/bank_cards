package com.example.bank_cards.controller.user;


import com.example.bank_cards.controller.user.dto.AuthCredentials;
import com.example.bank_cards.controller.user.dto.LoginCredentials;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthCredentials authCredentials) {

    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginCredentials loginCredentials) {

    }


}
