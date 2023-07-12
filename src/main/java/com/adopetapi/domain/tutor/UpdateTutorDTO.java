package com.adopetapi.domain.tutor;

import lombok.Builder;

@Builder
public record UpdateTutorDTO(
        String name,

        String phone,

        String city,

        String about
) {
}
