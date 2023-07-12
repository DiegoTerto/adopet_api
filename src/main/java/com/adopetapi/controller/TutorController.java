package com.adopetapi.controller;

import com.adopetapi.domain.tutor.TutorDTO;
import com.adopetapi.domain.tutor.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tutores")
public class TutorController {

    @Autowired
    private TutorService tutorService;

    @GetMapping()
    public ResponseEntity<List<TutorDTO>> list() {
        var tutores = tutorService.findAll();
        return ResponseEntity.ok(tutores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorDTO> getById(@PathVariable UUID id) {
        var tutor = tutorService.findById(id);
        return ResponseEntity.ok(tutor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable UUID id) {
        tutorService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
