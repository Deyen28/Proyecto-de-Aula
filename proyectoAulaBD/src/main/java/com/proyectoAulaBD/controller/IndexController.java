package com.proyectoAulaBD.controller;

import com.proyectoAulaBD.model.Reportes;
import com.proyectoAulaBD.service.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping("/reportes")
    public String mostrarReportes(Model model) {
        List<Reportes> reportes = reportesService.listarTodos();
        model.addAttribute("reportes", reportes);
        return "reportesView";
    }

}
