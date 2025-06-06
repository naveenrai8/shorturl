package com.nr.authservice.controller;

import com.nr.authservice.dto.LoginDto;
import com.nr.authservice.dto.TokenDto;
import com.nr.authservice.exception.UserAlreadyExistsException;
import com.nr.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto) throws UserAlreadyExistsException {
        final TokenDto token = this.authService.login(loginDto);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/validate")
    public ResponseEntity<Void> validateToken(@RequestHeader("Authorization") String token) {
        return this.authService.validate(token)
                ? ResponseEntity.ok().build()
                : ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
