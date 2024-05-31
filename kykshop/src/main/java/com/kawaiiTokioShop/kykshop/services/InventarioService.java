package com.kawaiiTokioShop.kykshop.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.InventarioModel;
import com.kawaiiTokioShop.kykshop.repositories.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<InventarioModel> getAllInventarios() {
        return inventarioRepository.findAll();
    }

    public Optional<InventarioModel> getInventarioById(int id) {
        return inventarioRepository.findById(id);
    }

    public InventarioModel saveInventario(InventarioModel inventarioModel) {
        return inventarioRepository.save(inventarioModel);
    }

    public void deleteInventario(int id) {
    	inventarioRepository.deleteById(id);
    }
    
    public InventarioModel getInventarioModelById(int id) {
        return inventarioRepository.findById(id)
                .orElse(null);
    }
    
    public List<InventarioModel> searchByArticulo(String keyword) {
        return inventarioRepository.searchByArticuloContaining(keyword);
    }
    
}
