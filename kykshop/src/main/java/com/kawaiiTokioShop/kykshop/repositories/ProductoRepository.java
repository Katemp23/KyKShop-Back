package com.kawaiiTokioShop.kykshop.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.ProductoModel;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Integer> {
	
	public abstract ArrayList<ProductoModel> findByTipoArticulo(String tipoArticulo);
	
    @Query(value = "SELECT DISTINCT tipo_articulo FROM productos", nativeQuery = true)
    public abstract List<String> findDistinctTipoArticulo();
    
    @Query(value = "SELECT * FROM productos WHERE caracteristicas LIKE %:keyword%", nativeQuery = true)
    List<ProductoModel> searchByCaracteristicasContaining(String keyword);
    
    @Query(value = "SELECT * FROM productos WHERE marca LIKE %:keyword%", nativeQuery = true)
    List<ProductoModel> searchByMarcaContaining(String keyword);
    
//    @Query(value = "SELECT DISTINCT tipo_articulo FROM productos", nativeQuery = true)
//    public abstract List<String> findByIdInventario();

}