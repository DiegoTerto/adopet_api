package com.adopetapi.domain.users;

import com.adopetapi.domain.tutor.CreateTutorDTOTestDataBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Mock
    private UsersRepository usersRepository;

    @Test
    void should_createUser() {
        var dto = CreateTutorDTOTestDataBuilder.build();

        when(usersRepository.existsByEmail(dto.email())).thenReturn(false);

        Assertions.assertDoesNotThrow(() -> userService.createUser(dto.email(), dto.password()));
        verify(usersRepository).save(any());
    }

    @Test
    void shouldThrowException_whenTryCreateUserWhatAlreadyExistByEmail() {
        var dto = CreateTutorDTOTestDataBuilder.build();

        when(usersRepository.existsByEmail(dto.email())).thenReturn(true);

        var exception = assertThrows(IllegalArgumentException.class, () -> userService.createUser(dto.email(), dto.password()));
        assertEquals("Já existe um cadastro com o email informado!", exception.getMessage());
    }
}
