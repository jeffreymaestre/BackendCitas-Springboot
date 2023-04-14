package com.citas.medicas.service;

import com.citas.medicas.dao.ICitaDao;
import com.citas.medicas.entity.Cita;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitaServiceImpl implements ICitaService{

    @Autowired
    private ICitaDao citaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cita> findAll() {
        return (List<Cita>) citaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cita findById(Long id) {
        return citaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cita save(Cita cita) {
        return citaDao.save(cita);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        citaDao.deleteById(id);
    }

    @Override
    @Transactional
    public void reservaCita(Long id) {
        Cita cita = citaDao.findById(id).orElseThrow(()-> new EntityNotFoundException("Cita no encontrada"));
        if (cita.isReserva()){
            throw new IllegalStateException("La cita ya esta agendada");
        }
        cita.setReserva(true);
        citaDao.save(cita);
    }

}
