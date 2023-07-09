package com.adopetapi.domain.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateTutorDTO(
        @NotBlank
        String name,

        @Email
        String email,

        @NotBlank
        String password
) {
}
