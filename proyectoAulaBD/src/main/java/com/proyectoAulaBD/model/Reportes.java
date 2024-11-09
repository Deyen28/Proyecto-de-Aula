package com.proyectoAulaBD.model;

import jakarta.persistence.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;


@Entity
@Table(name = "reportes")
public class Reportes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReportes;

    private String direccion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "contaminante_id")
    private Contaminante contaminante;

    @ManyToOne
    @JoinColumn(name = "barrio_id")
    private Barrios barrio;

    @Column(name = "fecha_reporte")
    private LocalDate fechaReporte;

    @Transient
    private String fechaReporteFormatted;

    // Getters y setters para fechaReporteFormatted
    public String getFechaReporteFormatted() {
        return fechaReporteFormatted;
    }

    public void setFechaReporteFormatted(String fechaReporteFormatted) {
        this.fechaReporteFormatted = fechaReporteFormatted;
    }

    @Column(name = "evidencia")
    private String evidencia;

    @Transient
    private MultipartFile evidenciaFile; // Campo para manejar la carga del archivo

    public MultipartFile getEvidenciaFile() {
        return evidenciaFile;
    }

    public void setEvidenciaFile(MultipartFile evidenciaFile) {
        this.evidenciaFile = evidenciaFile;
    }

    public Reportes() {
    }

    public Reportes(Long idReportes, String direccion, String descripcion, User user, Contaminante contaminante, Barrios barrio, LocalDate fechaReporte, String evidencia) {
        this.idReportes = idReportes;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.user = user;
        this.contaminante = contaminante;
        this.barrio = barrio;
        this.fechaReporte = fechaReporte;
        this.evidencia = evidencia;
    }

    public Long getIdReportes() {
        return idReportes;
    }

    public void setIdReportes(Long idReportes) {
        this.idReportes = idReportes;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Contaminante getContaminante() {
        return contaminante;
    }

    public void setContaminante(Contaminante contaminante) {
        this.contaminante = contaminante;
    }

    public Barrios getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrios barrio) {
        this.barrio = barrio;
    }

    public LocalDate getFechaReporte() {
        return fechaReporte;
    }

    public void setFechaReporte(LocalDate fechaReporte) {
        this.fechaReporte = fechaReporte;
    }

    public String getEvidencia() {
        return evidencia;
    }

    public void setEvidencia(String evidencia) {
        this.evidencia = evidencia;
    }
}
