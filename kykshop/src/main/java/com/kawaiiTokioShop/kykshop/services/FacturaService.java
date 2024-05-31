package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.FacturaModel;
import com.kawaiiTokioShop.kykshop.repositories.FacturaRepository;

@Service
public class FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    public List<FacturaModel> getAllFacturas() {
        return facturaRepository.findAll();
    }

    public Optional<FacturaModel> getFacturaById(int id) {
        return facturaRepository.findById(id);
    }

    public FacturaModel saveFactura(FacturaModel facturaModel) {
        return facturaRepository.save(facturaModel);
    }

    public void deleteFactura(int id) {
    	facturaRepository.deleteById(id);
    }
}

