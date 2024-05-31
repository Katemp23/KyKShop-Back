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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kawaiiTokioShop.kykshop.dto.CategoriaDto;
import com.kawaiiTokioShop.kykshop.dto.ProductoDto;
import com.kawaiiTokioShop.kykshop.models.ProductoModel;
import com.kawaiiTokioShop.kykshop.responses.ProductoResponse;
import com.kawaiiTokioShop.kykshop.services.ProductoService;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<ProductoResponse> getAllProductos() throws Exception {
//      List<ProductoModel> productos = productoService.getAllProductos();
        List<ProductoDto> productosDto = productoService.buscarProductosAMostrar(null);
        
        return new ResponseEntity<>(new ProductoResponse(productosDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDto> getProductoById(@PathVariable("id") int id) {
        ProductoModel productoModel =  productoService.getProductoById(id);
    	ProductoDto productoDto = productoService.convertirProductoModelADto(productoModel);
    	return new ResponseEntity<>(productoDto, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<ProductoModel> createProducto(@RequestBody ProductoModel producto) {
        ProductoModel createdProducto = productoService.saveProducto(producto);
        return new ResponseEntity<>(createdProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoModel> updateProducto(@PathVariable("id") int id, @RequestBody ProductoModel producto) {
        if (!productoService.getProductoByIdOptional(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        producto.setIdProducto(id);
        ProductoModel updatedProducto = productoService.saveProducto(producto);
        return new ResponseEntity<>(updatedProducto, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProducto(@PathVariable("id") int id) {
        if (!productoService.getProductoByIdOptional(id).isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productoService.deleteProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    
    @GetMapping("category/{id}")
    public ResponseEntity<ProductoResponse> getProductoByCategory(@PathVariable("id") String categoria) {
    	List<ProductoDto> productosDto = productoService.buscarProductosAMostrar(categoria);
                return new ResponseEntity<>(new ProductoResponse(productosDto), HttpStatus.OK);
    }
    
    @GetMapping("categories")
    public ResponseEntity<List<CategoriaDto>> getAllCategories() {
    	List<CategoriaDto> categorias = productoService.getAllCategorias();
                return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    
    @GetMapping("/search")
    public ResponseEntity<ProductoResponse> searchProductosByCaracteristicas(@RequestParam("keyword") String keyword) {
        List<ProductoDto> productosDto = productoService.searchByCaracteristica(keyword);
        System.out.println(productosDto);
    	return new ResponseEntity<>(new ProductoResponse(productosDto), HttpStatus.OK);
    }
}
