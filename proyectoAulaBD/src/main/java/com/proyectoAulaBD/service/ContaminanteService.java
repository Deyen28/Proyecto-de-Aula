package com.proyectoAulaBD.service;


import com.proyectoAulaBD.model.Contaminante;
import com.proyectoAulaBD.model.User;
import com.proyectoAulaBD.repository.ContaminateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaminanteService {

    @Autowired
    ContaminateRepository contaminateRepository;

    public List<Contaminante> listarTodosLosContaminantes() {
        return contaminateRepository.findAll();
    }

    public Contaminante obtenerPorId(Long id) {
        return contaminateRepository.findById(id).orElse(null);
    }
}
