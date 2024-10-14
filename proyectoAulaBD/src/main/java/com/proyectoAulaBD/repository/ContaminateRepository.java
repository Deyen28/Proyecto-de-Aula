package com.proyectoAulaBD.repository;

import com.proyectoAulaBD.model.Contaminante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaminateRepository extends JpaRepository<Contaminante, Long> {
}
