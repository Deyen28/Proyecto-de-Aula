package com.proyectoAulaBD.controller;

import com.proyectoAulaBD.model.User;
import com.proyectoAulaBD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/registerView")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "registerView";
    }
    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("user") User usuario, Model model) {
        usuario.setUserTipo(User.UserTipo.NORMAL);
        userService.guardar(usuario);
        return "redirect:/LoginView";
    }




}
