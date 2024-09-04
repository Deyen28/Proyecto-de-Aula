package com.proyectoDeAula.proyectoAula.Model;

public class Usuarios {

    private Long id;
    private String nombre;
    private String userName;
    private String email;
    private String direccion;
    private String contrasena;

    public Usuarios() {
    }

    public Usuarios(Long id, String nombre, String userName, String email, String direccion, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.userName = userName;
        this.email = email;
        this.direccion = direccion;
        this.contrasena = contrasena;
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

    @Override
    public String toString() {
        return "Usuarios{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
