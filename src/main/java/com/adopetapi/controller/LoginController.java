package com.adopetapi.controller;

import com.adopetapi.infra.security.AuthorizationDTO;
import com.adopetapi.infra.security.LoginDTO;
import com.adopetapi.infra.security.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping()
    public ResponseEntity<AuthorizationDTO> login(@RequestBody @Valid LoginDTO dto) {
        var token = loginService.auth(dto.email(), dto.password());
        return ResponseEntity.ok(new AuthorizationDTO(token));
    }
}
