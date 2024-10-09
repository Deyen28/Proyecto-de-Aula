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

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/LoginView")
    public String loginView(Model model) {
        model.addAttribute("user", new User());
        return "LoginView";
    }

    @PostMapping("/loguear")
    public String login(@ModelAttribute("user") User usuario, Model model, HttpSession session) {
        User user = userService.obtenerPorEmail(usuario.getEmail());
        if (user != null && user.getContrasena().equals(usuario.getContrasena())) {
            session.setAttribute("userId", user.getId());
            session.setAttribute("userType", user.getUserTipo());

            switch (user.getUserTipo()) {
                case ADMIN:
                    return "redirect:/admin/dashboard";
                case PRIVILEGED:
                    return "redirect:/privileged/dashboard";
                case NORMAL:
                default:
                    return "redirect:/user/dashboard";
            }
        } else {
            model.addAttribute("error", "Email o contraseña incorrectos");
            return "LoginView";
        }
    }

    //User

    @GetMapping("/user/dashboard")
    public String userDashboard(HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.NORMAL) {
            return "redirect:/LoginView";
        }
        return "editUser";
    }

// ADMIN
    @GetMapping("/admin/dashboard")
    public String adminDashboard(HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        return "adminView";
    }

    @GetMapping("/privileged/dashboard")
    public String privilegedDashboard(HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.PRIVILEGED) {
            return "redirect:/LoginView";
        }
        return "privilegedDashboard";
    }
}
