package com.proyectoAulaBD.service;

import com.proyectoAulaBD.model.Reportes;

import com.proyectoAulaBD.repository.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ReportesService {

    @Autowired
    private ReportesRepository reportesRepository;

    public Reportes guardar(Reportes reportes) {
        return reportesRepository.save(reportes);
    }

    public List<Reportes> listarTodos() {
        return reportesRepository.findAll();
    }

    public List<Reportes> obtenerReportesPorUsuario(Long userId) {
        return reportesRepository.findByUserId(userId);
    }

    public void eliminar(Long id) {
        reportesRepository.deleteById(id);
    }

    public Reportes obtenerPorId(Long id) {
        return reportesRepository.findById(id)
                .orElse(null);
    }


    public List<Object[]> contarReportesPorBarrioYContaminante(Long umbral) {
        // Primero obtener los barrios que cumplen con el umbral
        List<Object[]> barriosConUmbral = reportesRepository.contarReportesPorBarrio(umbral);

        if (barriosConUmbral.isEmpty()) {
            return new ArrayList<>();
        }

        // Obtener los nombres de los barrios que cumplen con el umbral
        List<String> nombresBarrios = barriosConUmbral.stream()
                .map(result -> (String) result[0])
                .collect(Collectors.toList());

        // Obtener los contaminantes para esos barrios
        List<Object[]> resultadosCompletos = reportesRepository
                .obtenerContaminantesPorBarrios(nombresBarrios);

        // Log para depuración
        System.out.println("Barrios que cumplen el umbral:");
        barriosConUmbral.forEach(r ->
                System.out.println(r[0] + ": " + r[1] + " reportes"));

        System.out.println("\nDetalle de contaminantes por barrio:");
        resultadosCompletos.forEach(r ->
                System.out.println(r[0] + " - " + r[1] + ": " + r[2] + " reportes"));

        return resultadosCompletos;
    }

    public List<Object[]> contaminantesMasReportados() {
        List<Object[]> resultados = reportesRepository.contaminantesMasReportados();
        System.out.println("Resultados de contaminantes más reportados:");
        for (Object[] resultado : resultados) {
            System.out.println("Contaminante: " + resultado[0] +
                    ", Cantidad: " + resultado[1]);
        }
        return resultados;
    }
}
