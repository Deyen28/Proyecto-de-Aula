package com.proyectoAulaBD.model;

import jakarta.persistence.*;


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

    public Reportes() {}

    public Reportes(String direccion, String descripcion, User user, Contaminante contaminante, Barrios barrio) {
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.user = user;
        this.contaminante = contaminante;
        this.barrio = barrio;
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
}
