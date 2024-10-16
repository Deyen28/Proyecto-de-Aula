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


import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public String deleteUser(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            userService.eliminar(id);
            redirectAttributes.addFlashAttribute("success", "Usuario eliminado exitosamente");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar el usuario: " + e.getMessage());
        }
        return "redirect:/admin/dashboard";
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public User getUser(@PathVariable Long id) {
        return userService.obtenerPorId(id);
    }

    @PostMapping("/updateUser/{id}")
    @ResponseBody
    public Map<String, Object> updateUser(@PathVariable Long id, @ModelAttribute User updatedUser) {
        Map<String, Object> response = new HashMap<>();
        try {
            User existingUser = userService.obtenerPorId(id);
            existingUser.setNombre(updatedUser.getNombre());
            existingUser.setUserName(updatedUser.getUserName());
            existingUser.setEmail(updatedUser.getEmail());
            existingUser.setDireccion(updatedUser.getDireccion());
            existingUser.setUserTipo(updatedUser.getUserTipo());

            userService.actualizarUsuario(existingUser);
            response.put("success", true);
        } catch (Exception e) {
            response.put("success", false);
            response.put("error", e.getMessage());
        }
        return response;
    }

    @GetMapping("/userReports/{id}")
    public String showUserReports(@PathVariable Long id, Model model) {
        User user = userService.obtenerPorId(id);
        List<Reportes> reportes = reportesService.obtenerReportesPorUsuario(id);
        model.addAttribute("user", user);
        model.addAttribute("reportes", reportes);
        return "adminRepoUser";
    }

}
