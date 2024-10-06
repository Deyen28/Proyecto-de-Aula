package com.proyectoAulaBD.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String userName;

    @Column(unique = true)
    private String email;

    private String direccion;
    private String contrasena;

    @Enumerated(EnumType.STRING)
    private UserTipo userTipo;

    public enum UserTipo {
        NORMAL, ADMIN, PRIVILEGED
    }

    public User() {
    }

    public User(Long id, String nombre, String userName, String email, String direccion, String contrasena, UserTipo userTipo) {
        this.id = id;
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.direccion = direccion;
        this.contrasena = contrasena;
        this.userTipo = userTipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public UserTipo getUserTipo() {
        return userTipo;
    }

    public void setUserTipo(UserTipo userTipo) {
        this.userTipo = userTipo;
    }
}
