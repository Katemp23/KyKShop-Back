package com.kawaiiTokioShop.kykshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kawaiiTokioShop.kykshop.models.PersonaModel;
import com.kawaiiTokioShop.kykshop.services.PersonaService;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping
    public ResponseEntity<List<PersonaModel>> getAllPersonas() {
        List<PersonaModel> personas = personaService.getAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonaModel> getPersonaById(@PathVariable("id") int id) {
        return personaService.getPersonaById(id)
                .map(persona -> new ResponseEntity<>(persona, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @GetMapping("/correo/{correo}")
    public ResponseEntity<PersonaModel> getPersonaByCorreo(@PathVariable("correo") String correo) {
        PersonaModel persona =  personaService.getPersonaByCorreo(correo);
        return new ResponseEntity<>(persona, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonaModel> createPersona(@RequestBody PersonaModel persona) {
        PersonaModel createdPersona = personaService.savePersona(persona);
        return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PersonaModel> updatePersona(@PathVariable("id") int id, @RequestBody PersonaModel persona) {
//        if (!personaService.getPersonaById(id).isPresent()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        persona.setIdPersona(id);
        persona.setIdTipoPersona(persona.getIdTipoPersona() != null ? persona.getIdTipoPersona() : "1");
        persona.setIdCargo(persona.getIdCargo() != 0 ? persona.getIdCargo() : 2);
        PersonaModel updatedPersona = personaService.savePersona(persona);
        return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable("id") int id) {
        if (!personaService.getPersonaById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        personaService.deletePersona(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

