package com.proyectoAulaBD.repository;

import com.proyectoAulaBD.model.Reportes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReportesRepository extends JpaRepository<Reportes, Long> {
    List<Reportes> findByUserId(Long userId);
    Page<Reportes> findByBarrioNombreBarrioContainingIgnoreCase(String barrio, Pageable pageable);

    @Query("SELECT b.nombreBarrio, " +
            "GROUP_CONCAT(DISTINCT c.nombreContaminante) as contaminantes, " +
            "COUNT(r) as total " +
            "FROM Reportes r " +
            "JOIN r.barrio b " +
            "JOIN r.contaminante c " +
            "GROUP BY b.nombreBarrio " +
            "HAVING COUNT(r) >= :umbral " +
            "ORDER BY total DESC")
    List<Object[]> contarReportesPorBarrioYContaminante(@Param("umbral") Long umbral);

    // Si tu base de datos no soporta GROUP_CONCAT, puedes usar esta alternativa:
    @Query("SELECT b.nombreBarrio, COUNT(r) as total " +
            "FROM Reportes r " +
            "JOIN r.barrio b " +
            "GROUP BY b.nombreBarrio " +
            "HAVING COUNT(r) >= :umbral " +
            "ORDER BY total DESC")
    List<Object[]> contarReportesPorBarrio(@Param("umbral") Long umbral);

    @Query("SELECT b.nombreBarrio, c.nombreContaminante, COUNT(r) " +
            "FROM Reportes r " +
            "JOIN r.barrio b " +
            "JOIN r.contaminante c " +
            "WHERE b.nombreBarrio IN :barrios " +
            "GROUP BY b.nombreBarrio, c.nombreContaminante")
    List<Object[]> obtenerContaminantesPorBarrios(@Param("barrios") List<String> barrios);

    // Obtiene los contaminantes más reportados sin importar el barrio
    @Query("SELECT c.nombreContaminante, COUNT(r) as cantidad " +
            "FROM Reportes r " +
            "JOIN r.contaminante c " +
            "GROUP BY c.nombreContaminante " +
            "ORDER BY cantidad DESC")
    List<Object[]> contaminantesMasReportados();



}