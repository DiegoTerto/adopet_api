package com.adopetapi.controller;

import com.adopetapi.domain.tutor.CreateTutorDTO;
import com.adopetapi.domain.tutor.TutorService;
import com.adopetapi.infra.security.AuthorizationDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private TutorService tutorService;

    @PostMapping
    public ResponseEntity<AuthorizationDTO> createTutor(@RequestBody @Valid CreateTutorDTO dto){
        var login = tutorService.createTutor(dto);
        return ResponseEntity.ok(login);
    }
}
