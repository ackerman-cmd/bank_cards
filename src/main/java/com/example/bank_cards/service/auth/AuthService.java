package com.example.bank_cards.service.auth;

import com.example.bank_cards.configuration.security.JwtUtil;
import com.example.bank_cards.controller.auth.dto.AuthCredentials;
import com.example.bank_cards.controller.auth.dto.JwtTokenResponse;
import com.example.bank_cards.controller.auth.dto.LoginCredentials;
import com.example.bank_cards.entity.user.User;
import com.example.bank_cards.infrastructure.exception.business.BusinessException;
import com.example.bank_cards.infrastructure.exception.business.BusinessExceptionCode;
import com.example.bank_cards.infrastructure.exception.validation.ValidationException;
import com.example.bank_cards.infrastructure.exception.validation.ValidationExceptionCode;
import com.example.bank_cards.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final JwtUtil jwtUtil;

    public JwtTokenResponse register(AuthCredentials authCredentials) {
        Optional<User> user = userRepository.findByUserName(authCredentials.userName());

        if (user.isPresent()) {
            throw new BusinessException(BusinessExceptionCode.USER_ALREADY_EXIST.getValue());
        }

        User current = User.builder()
                .id(null)
                .userName(authCredentials.userName())
                .passwordHash(passwordEncoder.encode(authCredentials.password()))
                .userRole(authCredentials.role())
                .email(authCredentials.email())
                .cards(null)
                .build();
        User saved = userRepository.save(current);
        return new JwtTokenResponse(jwtUtil.generateToken(saved));
    }

    public JwtTokenResponse login(LoginCredentials loginCredentials) {
        Optional<User> user = userRepository.findByUserName(loginCredentials.userName());

        if (user.isEmpty()) {
            throw new BusinessException(BusinessExceptionCode.USER_NOT_FOUND.getValue());
        }

        if (!passwordEncoder.matches(loginCredentials.password(), user.get().getPassword())) {
            throw new ValidationException(ValidationExceptionCode.ACCESS_DENIED.getValue());
        }

        return new JwtTokenResponse(jwtUtil.generateToken(user.get()));
    }
}
