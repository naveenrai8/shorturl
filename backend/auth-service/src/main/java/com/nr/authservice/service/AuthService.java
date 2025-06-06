package com.nr.authservice.service;

import com.nr.authservice.dto.LoginDto;
import com.nr.authservice.dto.TokenDto;
import com.nr.authservice.exception.UserAlreadyExistsException;
import com.nr.authservice.model.User;
import com.nr.authservice.repository.UserRepository;
import com.nr.authservice.utils.JwtUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtils jwtUtils;

    public TokenDto login(LoginDto loginDto) throws UserAlreadyExistsException {
        User user = this.userRepository.findByEmail(loginDto.email());
        if (user == null) {
            var message = String.format("User %s already exists", loginDto.email());
            log.info(message);
            user = this.userRepository.save(User
                    .builder()
                    .email(loginDto.email())
                    .password(passwordEncoder.encode(loginDto.password()))
                    .roles(loginDto.roles())
                    .build());
        }

        log.info(user.toString());
        String token = this.jwtUtils.generateToken(user.getEmail(), user.getRoles());
        return new TokenDto(token);
    }

    public boolean validate(String token) {
        return this.jwtUtils.validateToken(token);
    }
}
