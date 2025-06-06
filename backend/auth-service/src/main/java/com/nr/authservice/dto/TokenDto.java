package com.nr.authservice.dto;

import lombok.Builder;

@Builder
public record TokenDto(String token) {
}
