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

import com.kawaiiTokioShop.kykshop.dto.CheckoutDto;
import com.kawaiiTokioShop.kykshop.models.PedidoModel;
import com.kawaiiTokioShop.kykshop.responses.FacturaProductosResponse;
import com.kawaiiTokioShop.kykshop.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public ResponseEntity<List<PedidoModel>> getAllPedidos() {
        List<PedidoModel> pedidos = pedidoService.getAllPedidos();
        return new ResponseEntity<>(pedidos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoModel> getPedidoById(@PathVariable("id") int id) {
        return pedidoService.getPedidoById(id)
                .map(pedido -> new ResponseEntity<>(pedido, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

//    @PostMapping
//    public ResponseEntity<PedidoModel> createPedido(@RequestBody PedidoModel pedido) {
//        PedidoModel createdPedido = pedidoService.savePedido(pedido);
//        return new ResponseEntity<>(createdPedido, HttpStatus.CREATED);
//    }

    @PutMapping("/{id}")
    public ResponseEntity<PedidoModel> updatePedido(@PathVariable("id") int id, @RequestBody PedidoModel pedido) {
        if (!pedidoService.getPedidoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedido.setIdPedido(id);
        PedidoModel updatedPedido = pedidoService.savePedido(pedido);
        return new ResponseEntity<>(updatedPedido, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePedido(@PathVariable("id") int id) {
        if (!pedidoService.getPedidoById(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        pedidoService.deletePedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @PostMapping("/createCompra")
    public ResponseEntity<CheckoutDto> createCompra(@RequestBody CheckoutDto pedido) {
    	CheckoutDto factura = pedidoService.createPedido(pedido);
        return new ResponseEntity<>(factura, HttpStatus.CREATED);
    }
    
    @GetMapping("/facturas/{email}")
    public ResponseEntity<List<FacturaProductosResponse>> getAllPedidosFacturas(@PathVariable("email") String email) {
    	List<FacturaProductosResponse> fpr = pedidoService.getPedidoFacturas(email);
    	System.out.println(fpr);
        return new ResponseEntity<>(fpr, HttpStatus.OK);
    }

}
