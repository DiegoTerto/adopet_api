package com.adopetapi.domain.tutor;

import com.adopetapi.domain.users.UserService;
import com.adopetapi.infra.security.AuthorizationDTO;
import com.adopetapi.infra.security.LoginService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.hibernate.boot.model.naming.IllegalIdentifierException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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
        var tokenJWT = loginService.auth(dto.email(), dto.password());
        return new AuthorizationDTO(tokenJWT);
    }

    public List<TutorDTO> findAll() {
        var tutors = tutorRepository.findAll();
        if (tutors.isEmpty()) {
            throw new RuntimeException("Nenhum tutor encontrado");
        }
        return tutors.stream().map(TutorDTO::new).toList();
    }

    public TutorDTO findById(UUID id) {
        var tutor = tutorRepository.findById(id)
                .orElseThrow(() -> new IllegalIdentifierException("Tutor nao encontrado"));
        return new TutorDTO(tutor);
    }

    @Transactional
    public void delete(UUID id) {
        var deleteTutor = tutorRepository.findById(id).orElseThrow(() -> new IllegalIdentifierException("Tutor nao encontrado"));
        tutorRepository.delete(deleteTutor);
    }

    @Transactional
    public TutorDTO update(UpdateTutorDTO dto, UUID id) {
        var tutor = tutorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Tutor nao encontrado"));
        tutor.update(dto);
        var tutorUpdated = tutorRepository.save(tutor);
        return new TutorDTO(tutorUpdated);
    }
}
