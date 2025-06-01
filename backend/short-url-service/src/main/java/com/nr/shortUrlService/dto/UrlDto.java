package com.nr.shortUrlService.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record UrlDto(
        @NotBlank(message = "Url mustn't be blank")
        String url
) {
}
