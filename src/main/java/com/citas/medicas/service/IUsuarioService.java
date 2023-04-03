package com.citas.medicas.service;

import com.citas.medicas.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);
}
