package com.adopetapi.domain.tutor;

public class CreateTutorDTOTestDataBuilder {

    private static final String NAME = "goku";

    private static final String EMAIL = "goku@email.com";

    private static final String PASSWORD = "Senha1234";

    public static CreateTutorDTO build() {
        return CreateTutorDTO.builder()
                .name(NAME)
                .email(EMAIL)
                .password(PASSWORD)
                .build();
    }
}
