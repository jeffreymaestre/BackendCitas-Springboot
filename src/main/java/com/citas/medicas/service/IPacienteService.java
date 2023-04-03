package com.citas.medicas.service;

import com.citas.medicas.entity.Paciente;

import java.util.List;

public interface IPacienteService {

    public List<Paciente> findAll();

    public Paciente finById(Long id);

    public Paciente save (Paciente paciente);

    public void delete(Long id);
}
