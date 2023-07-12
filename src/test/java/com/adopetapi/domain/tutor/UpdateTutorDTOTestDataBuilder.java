package com.adopetapi.domain.tutor;

public class UpdateTutorDTOTestDataBuilder {

    private static final String NAME = "goku";

    private static final String PHONE = "44555669988";

    private static final String ABOUT = "Sobre alguma coisa";

    private static final String CITY = "New York";

    public static UpdateTutorDTO build() {
        return UpdateTutorDTO.builder()
                .name(NAME)
                .phone(PHONE)
                .city(CITY)
                .about(ABOUT)
                .build();
    }
}
