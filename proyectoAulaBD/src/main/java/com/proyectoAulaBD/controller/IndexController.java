package com.proyectoAulaBD.controller;

import com.proyectoAulaBD.model.Reportes;
import com.proyectoAulaBD.service.ReportesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private ReportesService reportesService;

    @GetMapping("/reportes")
    public String mostrarReportes(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(required = false) String search,
                                  Model model) {
        int pageSize = 4; // Número de reportes por página
        Pageable pageable = PageRequest.of(page, pageSize);
        Page<Reportes> reportesPage;

        if (search != null && !search.isEmpty()) {
            reportesPage = reportesService.buscarReportesPorBarrio(search, pageable);
        } else {
            reportesPage = reportesService.listarTodos(pageable);
        }

        // Formatear la fecha
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Reportes> reportesFormateados = reportesPage.getContent().stream()
                .map(reporte -> {
                    reporte.setFechaReporteFormatted(reporte.getFechaReporte().format(formatter));
                    return reporte;
                })
                .collect(Collectors.toList());

        model.addAttribute("reportes", reportesFormateados);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", reportesPage.getTotalPages());
        model.addAttribute("search", search); // Agregar el parámetro de búsqueda al modelo
        return "reportesView"; // Cambia esto por el nombre de tu vista
    }

}
