package com.proyectoDeAula.proyectoAula.Interface;

import com.proyectoDeAula.proyectoAula.Model.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository {

    List<Usuarios> encontrarTodo();
    void guardar(Usuarios usuario);
}
