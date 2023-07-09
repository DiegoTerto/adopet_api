package com.adopetapi.domain.tutor;

import com.adopetapi.domain.users.UserService;
import com.adopetapi.domain.users.UsersRepository;
import com.adopetapi.infra.security.AuthorizationDTO;
import com.adopetapi.infra.security.LoginService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;

    private final LoginService loginService;

    private final UserService userService;

    @Transactional
    public AuthorizationDTO createTutor(CreateTutorDTO dto) {
        var user = userService.createUser(dto.email(), dto.password());
        var tutor = new Tutor(dto, user);
        tutorRepository.save(tutor);
        var tokenJWT = loginService.auth(tutor.getUsers().getUsername(), dto.password());
        return new AuthorizationDTO(tokenJWT);
    }
}
