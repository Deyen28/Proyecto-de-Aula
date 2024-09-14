package com.Proyceto01.ProyectoAula_1.interfaces;

import com.Proyceto01.ProyectoAula_1.model.Users;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo {

    List<Users> encontrarTodo();

    void guardar(Users usuario);
}
