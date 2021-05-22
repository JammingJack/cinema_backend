package com.enset.cineam_app.dao;

import com.enset.cineam_app.entities.Seance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
}
