package com.citas.medicas.service;

import com.citas.medicas.dao.IMedicoDao;
import com.citas.medicas.entity.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MedicoServiceImpl implements IMedicoService{

    @Autowired
    private IMedicoDao medicoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Medico> findAll() {
        return (List<Medico>) medicoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Medico findById(Long id) {
        return medicoDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Medico save(Medico medico) {
        return medicoDao.save(medico);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        medicoDao.deleteById(id);
    }
}
