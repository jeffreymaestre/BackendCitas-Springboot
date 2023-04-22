package com.citas.medicas.controllers;

import com.citas.medicas.entity.Medico;
import com.citas.medicas.service.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MedicoRestController {
    @Autowired
    private IMedicoService medicoService;

    @GetMapping("/medicos")
    public List<Medico> index(){
        return medicoService.findAll();
    }

    @GetMapping("/medicos/{id}")
    public Medico show(@PathVariable Long id){
        return medicoService.findById(id);
    }

    @PostMapping("/medicos")
    @ResponseStatus(HttpStatus.CREATED)
    public Medico create(@RequestBody Medico medico){
        return medicoService.save(medico);
    }

    @PutMapping("/medicos/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Medico update(@PathVariable Long id, @RequestBody Medico medico){
        Medico medicoActual = medicoService.findById(id);

        medicoActual.setNombre(medico.getNombre());
        medicoActual.setApellido(medico.getApellido());
        medicoActual.setEspecialidad(medico.getEspecialidad());

        return medicoService.save(medicoActual);
    }

    @DeleteMapping("/medicos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        medicoService.deleteById(id);
    }
}
