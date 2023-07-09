package com.adopetapi.domain.tutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TutorRepository extends JpaRepository<Tutor, UUID> {
}
