package com.citas.medicas.dao;

import com.citas.medicas.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioDao extends CrudRepository <Usuario, Long> {

    public Usuario findByUsername (String username);
}
