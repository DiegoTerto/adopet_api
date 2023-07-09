package com.adopetapi.infra.security;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String email,

        @NotBlank
        String password
) {
}
