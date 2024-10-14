package com.proyectoAulaBD.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "barrios")
public class Barrios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarrio;

    private String nombreBarrio;

    @OneToMany(mappedBy = "barrio", cascade = CascadeType.ALL)
    private List<Reportes> reportes = new ArrayList<>();

    public Barrios() {}

    public Barrios(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public Long getIdBarrio() {
        return idBarrio;
    }

    public void setIdBarrio(Long idBarrio) {
        this.idBarrio = idBarrio;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public List<Reportes> getReportes() {
        return reportes;
    }

    public void setReportes(List<Reportes> reportes) {
        this.reportes = reportes;
    }
}
