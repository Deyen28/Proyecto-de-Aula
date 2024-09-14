package com.Proyceto01.ProyectoAula_1.controller;

import com.Proyceto01.ProyectoAula_1.interImple.UserRepoImpl;
import com.Proyceto01.ProyectoAula_1.model.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    private UserRepoImpl userRepoImpl;

    @GetMapping("/LoginView")
    public String loginView(){
        return "LoginView";
    }

    @PostMapping("/loguear")
    public String login(@ModelAttribute Users usuario, Model model) {
        Users user = userRepoImpl.logear(usuario.getEmail(), usuario.getContrasena());
        if (usuario != null && user.getEmail().equals(usuario.getEmail()) && user.getContrasena().equals(usuario.getContrasena())){
            System.out.println("Todo bien todo correcto");
            return "redirect:/dashboard";
        } else {
            model.addAttribute("error", "Email no encontrado");
            return "redirect:/LoginView";
        }
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }


}
