package com.adopetapi.domain.tutor;

import java.util.UUID;

public record TutorDTO(
        UUID id,
        String name,
        String city,
        String about,
        byte[] photo
) {

    TutorDTO(Tutor tutor) {
        this(tutor.getId(), tutor.getName(), tutor.getCity(), tutor.getAbout(), tutor.getPhoto());
    }
}
