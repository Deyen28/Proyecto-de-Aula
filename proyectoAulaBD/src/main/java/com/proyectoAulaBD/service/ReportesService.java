package com.proyectoAulaBD.service;

import com.proyectoAulaBD.model.Reportes;

import com.proyectoAulaBD.repository.ReportesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportesService {

    @Autowired
    private ReportesRepository reportesRepository;

    public Reportes guardar(Reportes reportes) {
        return reportesRepository.save(reportes);
    }
}
