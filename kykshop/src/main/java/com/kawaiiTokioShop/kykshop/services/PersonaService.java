package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.PersonaModel;
import com.kawaiiTokioShop.kykshop.repositories.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    public List<PersonaModel> getAllPersonas() {
        return personaRepository.findAll();
    }

    public Optional<PersonaModel> getPersonaById(int id) {
        return personaRepository.findById(id);
    }

    public PersonaModel savePersona(PersonaModel persona) {
        return personaRepository.save(persona);
    }

    public void deletePersona(int id) {
    	personaRepository.deleteById(id);
    }
}

