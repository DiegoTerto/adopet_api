package com.adopetapi.domain.users;

import com.adopetapi.domain.tutor.Tutor;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Entity(name = "Users")
@Table(name = "users")
@NoArgsConstructor
@Getter
@EqualsAndHashCode
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String email;

    private String password;
}
