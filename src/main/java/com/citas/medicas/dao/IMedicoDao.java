package com.citas.medicas.dao;

import com.citas.medicas.entity.Medico;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMedicoDao extends CrudRepository<Medico,Long> {
}
