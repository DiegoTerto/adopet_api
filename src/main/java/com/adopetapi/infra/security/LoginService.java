package com.adopetapi.infra.security;

import com.adopetapi.domain.users.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public String auth(String email, String password) {
        var token = new UsernamePasswordAuthenticationToken(email, password);
        var authentication = authenticationManager.authenticate(token);
        return tokenService.gerarToken((Users) authentication.getPrincipal());
    }
}
