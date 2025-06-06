package com.nr.authservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.util.List;

@Builder
public record LoginDto(
        @NotBlank
        String email,
        @NotBlank
        String password,
        @NotBlank
        List<String> roles
) {
}
