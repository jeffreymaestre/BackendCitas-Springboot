package com.citas.medicas.controllers;

import com.citas.medicas.entity.Paciente;
import com.citas.medicas.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PacienteRestController {

    @Autowired
    private IPacienteService pacienteService;

    @GetMapping("/pacientes")
    public List<Paciente> index(){
        return pacienteService.findAll();
    }

    @GetMapping("/pacientes/{id}")
    public Paciente show(@PathVariable Long id){
        return pacienteService.finById(id);
    }

    @PostMapping("/pacientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente create(@RequestBody Paciente paciente){
        return pacienteService.save(paciente);
    }

    @PutMapping("/pacientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Paciente update(@RequestBody Paciente paciente, @PathVariable Long id){
        Paciente pacienteActual = pacienteService.finById(id);

        pacienteActual.setNombre(paciente.getNombre());
        pacienteActual.setApellido(paciente.getApellido());
        pacienteActual.setEmail(paciente.getEmail());

        return pacienteService.save(pacienteActual);
    }

    @DeleteMapping("/pacientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        pacienteService.delete(id);
    }


}
