package com.proyectoAulaBD.service;

import com.proyectoAulaBD.model.Barrios;
import com.proyectoAulaBD.model.Contaminante;
import com.proyectoAulaBD.repository.BarriosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BarriosService {
    @Autowired
    private BarriosRepository barriosRepository;

    public List<Barrios> listarTodosLosBarrios() {
        return barriosRepository.findAll();
    }

    public Barrios obtenerPorId(Long id) {
        return barriosRepository.findById(id).orElse(null);
    }
}
