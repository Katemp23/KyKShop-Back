package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.CiudadModel;
import com.kawaiiTokioShop.kykshop.repositories.CiudadRepository;

@Service
public class CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    public List<CiudadModel> getAllCiudades() {
        return ciudadRepository.findAll();
    }

    public Optional<CiudadModel> getCiudadById(String id) {
        return ciudadRepository.findById(id);
    }

    public CiudadModel saveCiudad(CiudadModel ciudad) {
        return ciudadRepository.save(ciudad);
    }

    public void deleteCiudad(String id) {
        ciudadRepository.deleteById(id);
    }
}
