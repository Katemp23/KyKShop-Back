package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.TipoPersonaModel;
import com.kawaiiTokioShop.kykshop.repositories.TipoPersonaRepository;

@Service
public class TipoPersonaService {

    @Autowired
    private TipoPersonaRepository tipoPersonaRepository;

    public List<TipoPersonaModel> getAllTipoPersonas() {
        return tipoPersonaRepository.findAll();
    }

    public Optional<TipoPersonaModel> getTipoPersonaById(int id) {
        return tipoPersonaRepository.findById(id);
    }

    public TipoPersonaModel saveTipoPersona(TipoPersonaModel tipoPersonaModel) {
        return tipoPersonaRepository.save(tipoPersonaModel);
    }

    public void deleteTipoPersona(int id) {
    	tipoPersonaRepository.deleteById(id);
    }
}
