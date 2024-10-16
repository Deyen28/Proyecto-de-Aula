package com.proyectoAulaBD.controller;

import com.proyectoAulaBD.model.Barrios;
import com.proyectoAulaBD.model.Contaminante;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BarriosService barriosService;
    @Autowired
    private ContaminanteService contaminanteService;
    @Autowired
    private ReportesService reportesService;

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

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    //User

    @GetMapping("/user/dashboard")
    public String userDashboard(HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.NORMAL) {
            return "redirect:/LoginView";
        }
        return "userIndex";
    }

    @GetMapping("/user/dashboard/userReportView")
    public String userReportView(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/LoginView";
        }

        model.addAttribute("user", new User());
        model.addAttribute("barrios", barriosService.listarTodosLosBarrios());
        model.addAttribute("contaminantes", contaminanteService.listarTodosLosContaminantes());
        model.addAttribute("reporte", new Reportes());

        // Agrega la lista de reportes del usuario
        List<Reportes> reportes = reportesService.obtenerReportesPorUsuario(userId);
        model.addAttribute("reportes", reportes);

        return "userReportes";
    }

    @PostMapping("/Reportar")
    public String registrarReporte(@ModelAttribute("reporte") Reportes reporte, HttpSession session) {
        User user = userService.obtenerPorId((Long) session.getAttribute("userId"));

        reporte.setUser(user);
        reporte.setContaminante(contaminanteService.obtenerPorId(reporte.getContaminante().getIdContaminante()));
        reporte.setBarrio(barriosService.obtenerPorId(reporte.getBarrio().getIdBarrio()));

        reportesService.guardar(reporte);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/user/dashboard/userEditView")
    public String userEditView(Model model, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/LoginView";
        }
        User user = userService.obtenerPorId(userId);
        model.addAttribute("user", user);
        return "editUser";
    }


    @PostMapping("/ActualizarUser")
    public String updateUser(@ModelAttribute("user") User updatedUser,

                             HttpSession session,
                             RedirectAttributes redirectAttributes) {
        Long userId = (Long) session.getAttribute("userId");
        if (userId == null) {
            return "redirect:/LoginView";
        }

        updatedUser.setId(userId);

        try {
            User savedUser = userService.actualizarUsuario(updatedUser);
            redirectAttributes.addFlashAttribute("success", "Perfil actualizado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al actualizar el perfil: " + e.getMessage());
        }

        return "redirect:/user/dashboard/userEditView";
    }


    // ADMIN
    @GetMapping("/admin/dashboard")
    public String adminDashboard(Model model,HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.ADMIN) {
            return "redirect:/LoginView";
        }
        List<User> usuarios = userService.listarTodos();
        model.addAttribute("usuarios", usuarios);
        return "adminView";
    }

    @GetMapping("/privileged/dashboard")
    public String privilegedDashboard(Model model,HttpSession session) {
        if (session.getAttribute("userId") == null || session.getAttribute("userType") != User.UserTipo.PRIVILEGED) {
            return "redirect:/LoginView";
        }
        return "privilegedDashboard";
    }
}
