package com.adopetapi.domain.tutor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record CreateTutorDTO(
        @NotBlank(message = "Nome não pode estar vazio")
        String name,

        @Email(message = "Formato do email invalido")
        String email,

        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z]).{6,15}$", message = "A senha deve conter pelo menos uma letra maiúscula, um número e ter entre 6 e 15 caracteres")
        String password
) {
}
