package com.proyectoAulaBD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("/reportes")
    public String reportesView(){
        return "reportesView";
    }

}
