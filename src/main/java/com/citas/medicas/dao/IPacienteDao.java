package com.citas.medicas.dao;

import com.citas.medicas.entity.Paciente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPacienteDao extends CrudRepository <Paciente, Long>{
}
