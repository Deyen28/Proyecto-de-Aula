package com.proyectoAulaBD.repository;

import com.proyectoAulaBD.model.Reportes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportesRepository extends JpaRepository<Reportes, Long> {
    List<Reportes> findByUserId(Long userId);
}
