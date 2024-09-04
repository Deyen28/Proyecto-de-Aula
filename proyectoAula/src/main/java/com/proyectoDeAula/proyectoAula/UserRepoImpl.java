package com.proyectoDeAula.proyectoAula;

import com.proyectoDeAula.proyectoAula.Interface.UsuarioRepository;
import com.proyectoDeAula.proyectoAula.Model.Usuarios;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

@Repository
public class UserRepoImpl implements UsuarioRepository {


    private List<Usuarios> usuarios = new ArrayList<>();


    @Override
    public List<Usuarios> encontrarTodo() {
        return usuarios;
    }

    @Override
    public void guardar(Usuarios usuario) {

    }
}
