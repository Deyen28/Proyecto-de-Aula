package com.proyectoAulaBD.controller;

import com.proyectoAulaBD.model.Reportes;
import com.proyectoAulaBD.model.User;
import com.proyectoAulaBD.service.BarriosService;
import com.proyectoAulaBD.service.ContaminanteService;
import com.proyectoAulaBD.service.ReportesService;
import com.proyectoAulaBD.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private BarriosService barriosService;
    @Autowired
    private ContaminanteService contaminanteService;
    @Autowired
    private ReportesService reportesService;

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/dashboard/reportes")
    public String adminDashboard(Model model,HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        List<Reportes> todosLosReportes = reportesService.listarTodos();

        model.addAttribute("totalReportes", todosLosReportes);
        return "adminReportes";
    }

    @GetMapping("/dashboard/profile")
    public String admiprofile(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/LoginView";
        }
        User user = userService.obtenerPorId(userId);
        model.addAttribute("user", user);
        return "adminProfile";
    }

    @PostMapping("/dashboard/ActualizarUser")
    public String adminupdateUser(@ModelAttribute("user") User updatedUser,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        updatedUser.setId(userId);
        try {
            User savedUser = userService.actualizarUsuario(updatedUser);
            redirectAttributes.addFlashAttribute("success", "Perfil actualizado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el perfil: " + e.getMessage());
        }

        return "redirect:/admin/dashboard/profile";
    }


    @PostMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable Long id, @RequestParam("_method") String method, HttpSession session) {
        if (method.equals("DELETE")) {
            if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.ADMIN) {
                return "redirect:/LoginView";
            }
            userService.eliminar(id);
            return "redirect:/admin/dashboard";
        } else {
            return "redirect:/";
        }
    }


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

}
