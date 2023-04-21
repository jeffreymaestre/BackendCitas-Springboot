package com.citas.medicas.service;

import com.citas.medicas.entity.Cita;

import java.util.List;

public interface ICitaService {

    public List<Cita> findAll();

    public Cita findById(Long id);

    public Cita save (Cita cita);

    public void delete (Long id);

    //public void reservaCita(Long id);

    public void agendarCita(Cita cita) throws Exception;
}
