package com.adopetapi.controller;

import com.adopetapi.domain.tutor.TutorDTO;
import com.adopetapi.domain.tutor.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping("/tutores")
    public ResponseEntity<List<TutorDTO>> list() {
        var tutores = tutorService.findAll();
        return ResponseEntity.ok(tutores);
    }

}
