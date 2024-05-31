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

import com.kawaiiTokioShop.kykshop.models.InventarioModel;
import com.kawaiiTokioShop.kykshop.services.InventarioService;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public ResponseEntity<List<InventarioModel>> getAllInventario() {
        List<InventarioModel> inventario = inventarioService.getAllInventarios();
        return new ResponseEntity<>(inventario, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioModel> getInventarioById(@PathVariable("id") int id) {
        return inventarioService.getInventarioById(id)
                .map(inventario -> new ResponseEntity<>(inventario, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<InventarioModel> createInventario(@RequestBody InventarioModel inventario) {
        InventarioModel createdInventario = inventarioService.saveInventario(inventario);
        return new ResponseEntity<>(createdInventario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioModel> updateInventario(@PathVariable("id") int id, @RequestBody InventarioModel inventario) {
        if (!inventarioService.getInventarioById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        inventario.setIdInventario(id);
        InventarioModel updatedInventario = inventarioService.saveInventario(inventario);
        return new ResponseEntity<>(updatedInventario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventario(@PathVariable("id") int id) {
        if (!inventarioService.getInventarioById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        inventarioService.deleteInventario(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
