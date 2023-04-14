package com.citas.medicas.controllers;

import com.citas.medicas.entity.Cita;
import com.citas.medicas.service.ICitaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CitaRestControllers {
    @Autowired
    private ICitaService citaService;

    @GetMapping("/citas")
    public List<Cita> index (){
        return citaService.findAll();
    }

    @GetMapping("/citas/{id}")
    public Cita show(@PathVariable Long id){
        return citaService.findById(id);
    }

    @PostMapping("/citas")
    @ResponseStatus(HttpStatus.CREATED)
    public Cita create(@RequestBody Cita cita){
        return citaService.save(cita);
        //return citaService.reservaCita(cita);
    }

    @PutMapping("/citas/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cita update(@RequestBody Cita cita, @PathVariable Long id){
        Cita citaActual = citaService.findById(id);

        citaActual.setMedico(cita.getMedico());
        citaActual.setPaciente(cita.getPaciente());
        citaActual.setFechaHora(cita.getFechaHora());

        return citaService.save(citaActual);
    }

    @DeleteMapping("/citas/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id){
        citaService.delete(id);
    }

    @PostMapping("/{id}/reservar")
    public ResponseEntity<?> reservarCita(@PathVariable Long id){
        try {
            citaService.reservaCita(id);
            return ResponseEntity.ok().build();
        } catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (IllegalStateException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
