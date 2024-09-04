package com.proyectoDeAula.proyectoAula.Controller;

import com.proyectoDeAula.proyectoAula.Model.Usuarios;
import com.proyectoDeAula.proyectoAula.UserRepoImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuariosController {

    @Autowired
    private UserRepoImpl userRepoImpl;

    @GetMapping("/login")
    public String loginView(){
        return "loginView";
    }

    @GetMapping("/reportes")
    public String reportesView(){
        return "reportesView";
    }

    @GetMapping("/registerView")
    public String registro(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "registerView";
    }

    @PostMapping("/registerView")
    public String registrarUsuario(@ModelAttribute("usuario") Usuarios usuario, Model model) {
        userRepoImpl.guardar(usuario);
        model.addAttribute("usuario", usuario);
        return "userDetail";
    }


}
