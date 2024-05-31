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

import com.kawaiiTokioShop.kykshop.models.EntradaAlmacenModel;
import com.kawaiiTokioShop.kykshop.services.EntradaAlmacenService;

@RestController
@RequestMapping("/entrada-almacen")
public class EntradaAlmacenController {

    @Autowired
    private EntradaAlmacenService entradaAlmacenService;

    @GetMapping
    public ResponseEntity<List<EntradaAlmacenModel>> getAllEntradasAlmacen() {
        List<EntradaAlmacenModel> entradasAlmacen = entradaAlmacenService.getAllEntradasAlmacen();
        return new ResponseEntity<>(entradasAlmacen, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntradaAlmacenModel> getEntradaAlmacenById(@PathVariable("id") int id) {
        return entradaAlmacenService.getEntradaAlmacenById(id)
                .map(entradaAlmacen -> new ResponseEntity<>(entradaAlmacen, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<EntradaAlmacenModel> createEntradaAlmacen(@RequestBody EntradaAlmacenModel entradaAlmacen) {
        EntradaAlmacenModel createdEntradaAlmacen = entradaAlmacenService.saveEntradaAlmacen(entradaAlmacen);
        return new ResponseEntity<>(createdEntradaAlmacen, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EntradaAlmacenModel> updateEntradaAlmacen(@PathVariable("id") int id, @RequestBody EntradaAlmacenModel entradaAlmacen) {
        if (!entradaAlmacenService.getEntradaAlmacenById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        entradaAlmacen.setIdAlmacen(id);
        EntradaAlmacenModel updatedEntradaAlmacen = entradaAlmacenService.saveEntradaAlmacen(entradaAlmacen);
        return new ResponseEntity<>(updatedEntradaAlmacen, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEntradaAlmacen(@PathVariable("id") int id) {
        if (!entradaAlmacenService.getEntradaAlmacenById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        entradaAlmacenService.deleteEntradaAlmacen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
