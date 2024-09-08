package com.Proyceto01.ProyectoAula_1.interImple;

import com.Proyceto01.ProyectoAula_1.interfaces.UserRepo;
import com.Proyceto01.ProyectoAula_1.model.Users;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepoImpl implements UserRepo {

    private List<Users> usuarios = new ArrayList<>();


    @Override
    public List<Users> encontrarTodo() {
        return usuarios;
    }

    @Override
    public void guardar(Users usuario) {
        usuarios.add(usuario);
    }
}
