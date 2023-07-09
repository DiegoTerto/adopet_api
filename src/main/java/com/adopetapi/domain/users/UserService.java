package com.adopetapi.domain.users;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UsersRepository usersRepository;

    private final int workload = 12;

    public Users createUser(String email, String password) {
        validateExistsByTutorByEmail(email);
        var passwordEncrypt = encrypt(password);
        return usersRepository.save(new Users(email, passwordEncrypt));
    }

    private String encrypt(String password) {
        String salt = BCrypt.gensalt(workload);
        return BCrypt.hashpw(password, salt);
    }

    private void validateExistsByTutorByEmail(String email) {
        var exists = usersRepository.existsByEmail(email);
        if (!exists) return;
        throw new IllegalArgumentException("Já existe um cadastro com o email informado!");
    }
}
