package com.proyectoAulaBD.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contaminante")
public class Contaminante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idContaminante;

    private String nombreContaminante;

    @OneToMany(mappedBy = "contaminante", cascade = CascadeType.ALL)
    private List<Reportes> reportes = new ArrayList<>();

    public Contaminante() {}

    public Contaminante(String nombreContaminante) {
        this.nombreContaminante = nombreContaminante;
    }

    public Long getIdContaminante() {
        return idContaminante;
    }

    public void setIdContaminante(Long idContaminante) {
        this.idContaminante = idContaminante;
    }

    public String getNombreContaminante() {
        return nombreContaminante;
    }

    public void setNombreContaminante(String nombreContaminante) {
        this.nombreContaminante = nombreContaminante;
    }

    public List<Reportes> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reportes> reportes) {
        this.reportes = reportes;
    }
}
