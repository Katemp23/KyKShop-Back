package com.kawaiiTokioShop.kykshop.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.convert.ProductoConvert;
import com.kawaiiTokioShop.kykshop.dto.CategoriaDto;
import com.kawaiiTokioShop.kykshop.dto.ProductoDto;
import com.kawaiiTokioShop.kykshop.models.InventarioModel;
import com.kawaiiTokioShop.kykshop.models.ProductoModel;
import com.kawaiiTokioShop.kykshop.repositories.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    
    @Autowired
    private InventarioService inventarioService;

    public List<ProductoModel> getAllProductos() {
        return productoRepository.findAll();
    }

    public ProductoModel getProductoById(int id) {
        return productoRepository.findById(id).orElse(null);
    }
    
    public Optional<ProductoModel> getProductoByIdOptional(int id) {
        return productoRepository.findById(id);
    }

    public ProductoModel saveProducto(ProductoModel productoModel) {
        return productoRepository.save(productoModel);
    }

    public void deleteProducto(int id) {
    	productoRepository.deleteById(id);
    }
    
    public List<ProductoDto> buscarProductosAMostrar(String categoria) {
    	List<ProductoDto> productosDto = new ArrayList<ProductoDto>();
    	List<ProductoModel> productos = new ArrayList<ProductoModel>();
    	
    	if (categoria != null && !categoria.isEmpty()) {
        	productos = this.productoRepository.findByTipoArticulo(categoria);
		} else {
	    	productos = this.productoRepository.findAll();
		}
    	
    	for (ProductoModel producto : productos) {
    		InventarioModel inventario = inventarioService.getInventarioModelById(producto.getIdInventario());
    		if (inventario != null) {
        		productosDto.add(ProductoConvert.convertToDto(producto, inventario));
			}
		}
    	
    	return productosDto;
    }
    
    public List<CategoriaDto> getAllCategorias() {
        List<String> categorias = productoRepository.findDistinctTipoArticulo();
        
        List<CategoriaDto> categoriasDto = new ArrayList<>();
        for (String categoriaOriginal : categorias) {
            String slug = categoriaOriginal.toUpperCase();
            String name = categoriaOriginal;
            categoriasDto.add(new CategoriaDto(slug, name));
        }
        
        return categoriasDto;
    }
    
    public List<ProductoDto> searchByCaracteristica(String Keyword) {
    	List<ProductoDto> productosDto = new ArrayList<ProductoDto>();
    	List<ProductoModel> productos = new ArrayList<ProductoModel>();
    	
    	productos = productoRepository.searchByCaracteristicasContaining(Keyword);
    	productos.addAll(productoRepository.searchByMarcaContaining(Keyword));
    	for (ProductoModel producto : productos) {
    		InventarioModel inventario = inventarioService.getInventarioModelById(producto.getIdInventario());
    		if (inventario != null) {
        		productosDto.add(ProductoConvert.convertToDto(producto, inventario));
			}
		}
    	
    	return productosDto;
    }
    

    public ProductoDto convertirProductoModelADto(ProductoModel producto) {
		InventarioModel inventario = inventarioService.getInventarioModelById(producto.getIdInventario());
		return ProductoConvert.convertToDto(producto, inventario); 
		
    }
		
}
