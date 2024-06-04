package com.kawaiiTokioShop.kykshop.services;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.dto.InventarioDto;
import com.kawaiiTokioShop.kykshop.models.EntradaAlmacenModel;
import com.kawaiiTokioShop.kykshop.models.InventarioModel;
import com.kawaiiTokioShop.kykshop.models.ProductoModel;
import com.kawaiiTokioShop.kykshop.repositories.EntradaAlmacenRepository;
import com.kawaiiTokioShop.kykshop.repositories.InventarioRepository;
import com.kawaiiTokioShop.kykshop.repositories.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;
    
    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private EntradaAlmacenRepository almacenRepository;

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
	
    public List<InventarioDto> getAllInventarioProductos() {
    	List<InventarioDto> inventarioProductos = new ArrayList<InventarioDto>();
    	List<ProductoModel> producto = productoRepository.findAll();
    	
    	for (ProductoModel productoModel : producto) {
			InventarioModel inventario = new InventarioModel();
	    	InventarioDto inventarioDto = new InventarioDto();
			inventario = inventarioRepository.findById(productoModel.getIdInventario()).orElse(null);
			inventarioDto.setInventario(inventario);
			inventarioDto.setProducto(productoModel);
			inventarioProductos.add(inventarioDto);
		}
    	
    	return inventarioProductos;
    }

    @Transactional
	public InventarioDto createInventarioProducto(InventarioDto inventarioDto) {
		
        inventarioDto.setInventario(inventarioRepository.save(inventarioDto.getInventario()));
        
        EntradaAlmacenModel almacen = new EntradaAlmacenModel();
        almacen.setCantidadComprada(inventarioDto.getInventario().getCantidad());
        almacen.setFechaEntrada(LocalDateTime.now());
        almacen.setIdPersona(1);
        almacen.setIdInventario(inventarioDto.getInventario().getIdInventario());
        almacenRepository.save(almacen);
        
        inventarioDto.getProducto().setIdAlmacen(almacen.getIdAlmacen());
        inventarioDto.getProducto().setIdInventario(inventarioDto.getInventario().getIdInventario());
        inventarioDto.setProducto(productoRepository.save(inventarioDto.getProducto()));
		
		return inventarioDto;
	}
    
    @Transactional
	public InventarioDto updateInventarioProducto(InventarioDto inventarioDto) {
		
        inventarioDto.setInventario(inventarioRepository.save(inventarioDto.getInventario()));
        
        inventarioDto.getProducto().setIdAlmacen(inventarioDto.getProducto().getIdAlmacen());
        inventarioDto.getProducto().setIdInventario(inventarioDto.getInventario().getIdInventario());
        inventarioDto.setProducto(productoRepository.save(inventarioDto.getProducto()));
		
		return inventarioDto;
	}

	public void deleteInventarioProducto(int idProducto) {
		
		ProductoModel producto = productoRepository.findById(idProducto).orElse(null);
		
    	inventarioRepository.deleteById(producto.getIdInventario());
    	
    	productoRepository.deleteById(idProducto);
		
	}
    
}
