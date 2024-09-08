package com.Proyceto01.ProyectoAula_1.controller;

import com.Proyceto01.ProyectoAula_1.interImple.UserRepoImpl;
import com.Proyceto01.ProyectoAula_1.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserRepoImpl userRepoImpl;

    @GetMapping("/registerView")
    public String showRegisterForm(Model model) {
        model.addAttribute("Users", new Users());
        return "registerView";
    }

    @PostMapping("/registrar")
    public String registar(@ModelAttribute("Users") Users usuario, Model model){
        userRepoImpl.guardar(usuario);
        model.addAttribute("Users",usuario);
        System.out.println("Usuario registrado"+ " "+ usuario.getNombre()+" "+ usuario.getEmail() );
        return "redirect:/listaUsuarios";
    }

    @GetMapping("/listaUsuarios")
    public String mostrarUsuarios(Model model){
        List<Users> usuarios = userRepoImpl.encontrarTodo();
        System.out.println("Tamaño de la lista: " + usuarios.size());
        for (Users usuario : usuarios) {
            System.out.println("Usuario: " + usuario.getNombre() + " " + usuario.getEmail());
        }
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios";
    }


}
