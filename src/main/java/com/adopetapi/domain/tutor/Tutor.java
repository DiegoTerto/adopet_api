package com.adopetapi.domain.tutor;

import com.adopetapi.domain.users.Users;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Entity(name = "Tutor")
@Table(name = "tutor")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    private String phone;

    private String city;

    private String about;

    private byte[] photo;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    public Tutor(CreateTutorDTO dto, Users user) {
        this.name = dto.name();
        this.users = user;
    }

    public void update(UpdateTutorDTO dto) {
        if (Objects.nonNull(dto.name())) {
            this.name = dto.name();
        }

        if (Objects.nonNull(dto.phone())) {
            this.phone = dto.phone();
        }

        if (Objects.nonNull(dto.city())) {
            this.city = dto.city();
        }

        if (Objects.nonNull(dto.about())) {
            this.about = dto.about();
        }
    }
}
