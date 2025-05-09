package com.example.bank_cards.configuration.security;

import com.example.bank_cards.infrastructure.exception.business.BusinessException;
import com.example.bank_cards.infrastructure.exception.business.BusinessExceptionCode;
import com.example.bank_cards.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserName(username)
                .orElseThrow(() -> new BusinessException(BusinessExceptionCode.USER_NOT_FOUND.getValue()));
    }
}
