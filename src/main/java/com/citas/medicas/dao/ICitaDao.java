package com.citas.medicas.dao;

import com.citas.medicas.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface ICitaDao extends JpaRepository<Cita, Long> {
    boolean existsByMedicoAndFechaHora(String medico, LocalDateTime fechaHora);
}
