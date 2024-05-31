package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.EntradaAlmacenModel;
import com.kawaiiTokioShop.kykshop.repositories.EntradaAlmacenRepository;

@Service
public class EntradaAlmacenService {

    @Autowired
    private EntradaAlmacenRepository entradaAlmacenRepository;

    public List<EntradaAlmacenModel> getAllEntradasAlmacen() {
        return entradaAlmacenRepository.findAll();
    }

    public Optional<EntradaAlmacenModel> getEntradaAlmacenById(int id) {
        return entradaAlmacenRepository.findById(id);
    }

    public EntradaAlmacenModel saveEntradaAlmacen(EntradaAlmacenModel entradaAlmacen) {
        return entradaAlmacenRepository.save(entradaAlmacen);
    }

    public void deleteEntradaAlmacen(int id) {
        entradaAlmacenRepository.deleteById(id);
    }
}
