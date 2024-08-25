package com.proyectoDeAula.proyectoAula.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ViewController {

    @GetMapping("/login")
    public String loginView(){
        return "loginView";
    }

    @GetMapping("/register")
    public String registerView(){
        return "registerView";
    }

    @GetMapping("/reportes")
    public String reportesView(){
        return "reportesView";
    }



}