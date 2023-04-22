package com.citas.medicas.service;

import com.citas.medicas.entity.Medico;

import java.util.List;

public interface IMedicoService {
    public List<Medico> findAll();
    public Medico findById(Long id);
    public Medico save(Medico medico);
    public void deleteById(Long id);
}
