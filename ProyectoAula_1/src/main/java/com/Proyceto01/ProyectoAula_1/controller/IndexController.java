package com.Proyceto01.ProyectoAula_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/login")
    public String loginView(){
        return "loginView";
    }

    @GetMapping("/reportes")
    public String reportesView(){
        return "reportesView";
    }

}
