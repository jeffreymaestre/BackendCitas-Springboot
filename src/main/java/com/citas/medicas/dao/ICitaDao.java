package com.citas.medicas.dao;

import com.citas.medicas.entity.Cita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICitaDao extends CrudRepository <Cita, Long> {
}
