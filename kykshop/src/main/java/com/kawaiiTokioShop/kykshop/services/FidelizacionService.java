package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.FidelizacionModel;
import com.kawaiiTokioShop.kykshop.repositories.FidelizacionRepository;

@Service
public class FidelizacionService {

    @Autowired
    private FidelizacionRepository fidelizacionRepository;

    public List<FidelizacionModel> getAllFidelizaciones() {
        return fidelizacionRepository.findAll();
    }

    public Optional<FidelizacionModel> getFidelizacionesById(int id) {
        return fidelizacionRepository.findById(id);
    }

    public FidelizacionModel saveFidelizacion(FidelizacionModel fidelizacionModel) {
        return fidelizacionRepository.save(fidelizacionModel);
    }

    public void deleteFidelizacion(int id) {
    	fidelizacionRepository.deleteById(id);
    }
}

