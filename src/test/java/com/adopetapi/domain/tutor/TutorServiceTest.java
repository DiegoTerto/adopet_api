package com.adopetapi.domain.tutor;

import com.adopetapi.domain.users.UserService;
import com.adopetapi.domain.users.Users;
import com.adopetapi.domain.users.UsersRepository;
import com.adopetapi.infra.security.AuthorizationDTO;
import com.adopetapi.infra.security.LoginService;
import com.adopetapi.infra.security.TokenService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TutorServiceTest {

    @InjectMocks
    private TutorService tutorService;

    @Mock
    private TutorRepository tutorRepository;

    @Mock
    private LoginService loginService;

    @Mock
    private UserService userService;

    @Mock
    private UsersRepository usersRepository;

    private static final String TOKEN = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJBZG9wZXQgQVBJIiwic3ViIjoiZGllZ28udGVydG9AZ21haWwuY29tIiwiZXhwIjoxNjg4OTQ3MzgwfQ.gwgValzKczjWLY6anv1ysUIuzThQVrELCfbx9Tq27Rw";

    @Test
    void should_createTutor() {
        var dto = CreateTutorDTOTestDataBuilder.build();
        var user = new Users(dto.email(), dto.password());

        when(usersRepository.existsByEmail(dto.email())).thenReturn(false);
        when(userService.createUser(dto.email(), dto.email())).thenReturn(user);
        assertDoesNotThrow(() -> userService.createUser(dto.email(), dto.password()));

        tutorService.createTutor(dto);
        verify(tutorRepository).save(any());
    }

    @Test
    void shouldThrowException_whenCreateTutor() {
        var dto = CreateTutorDTOTestDataBuilder.build();

        when(usersRepository.existsByEmail(dto.email())).thenReturn(true);
        when(userService.createUser(dto.email(), dto.password())).thenThrow(new IllegalArgumentException("Já existe um cadastro com o email informado!"));

        var exception = assertThrows(RuntimeException.class, () -> tutorService.createTutor(dto));

        assertEquals("Já existe um cadastro com o email informado!", exception.getMessage());
    }
}
