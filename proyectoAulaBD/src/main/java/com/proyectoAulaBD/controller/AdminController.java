package com.proyectoAulaBD.controller;

import com.proyectoAulaBD.model.User;
import com.proyectoAulaBD.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String showAdminAddUserForm(Model model, HttpSession session) {
        if (session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        model.addAttribute("user", new User());
        return "adminAddUser";
    }

    @PostMapping("/addUser")
    public String adminAddUser(@ModelAttribute("user") User usuario, HttpSession session) {
        if (session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        userService.guardar(usuario);
        return "redirect:/admin/userList";
    }

    @GetMapping("/userList")
    public String mostrarUsuarios(Model model, HttpSession session) {
        if (session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        List<User> usuarios = userService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "listaUsuarios";
    }
}
