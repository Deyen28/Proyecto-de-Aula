package com.proyectoAulaBD.service;

import com.proyectoAulaBD.model.Reportes;

import com.proyectoAulaBD.repository.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ReportesService {

    @Value("${app.upload.dir:${user.home}}")
    private String uploadDir;

    @Autowired
    private ReportesRepository reportesRepository;

    public Reportes guardar(Reportes reportes, MultipartFile evidencia) {
        reportes.setFechaReporte(LocalDate.now());

        if (evidencia != null && !evidencia.isEmpty()) {
            try {
                // Genera un nombre único para el archivo
                String fileName = UUID.randomUUID().toString() + "_" + evidencia.getOriginalFilename();

                // Crea el directorio si no existe
                String directorio = "C:/Users/esnne/OneDrive/Desktop/proyectoAulaBD/src/main/resources/evidencias";
                File carpeta = new File(directorio);
                if (!carpeta.exists()) {
                    carpeta.mkdirs();
                }

                // Ruta completa del archivo
                Path path = Paths.get(directorio + File.separator + fileName);

                // Guarda el archivo
                Files.copy(evidencia.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

                // Guarda el nombre del archivo en la base de datos
                reportes.setEvidencia(fileName);

            } catch (IOException e) {
                throw new RuntimeException("No se pudo guardar el archivo: " + e.getMessage());
            }
        }

        return reportesRepository.save(reportes);
    }

    public Page<Reportes> listarTodos(Pageable pageable) {
        return reportesRepository.findAll(pageable);
    }
    public Page<Reportes> buscarReportesPorBarrio(String barrio, Pageable pageable) {
        return reportesRepository.findByBarrioNombreBarrioContainingIgnoreCase(barrio, pageable);
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
