package com.citas.medicas.service;

import com.citas.medicas.dao.IPacienteDao;
import com.citas.medicas.entity.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDao pacienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> findAll() {
        return (List<Paciente>) pacienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Paciente finById(Long id) {
        return pacienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Paciente save(Paciente paciente) {
        return pacienteDao.save(paciente);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pacienteDao.deleteById(id);
    }
}
