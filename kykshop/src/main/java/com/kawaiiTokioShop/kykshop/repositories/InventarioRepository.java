package com.kawaiiTokioShop.kykshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.InventarioModel;

@Repository
public interface InventarioRepository extends JpaRepository<InventarioModel, Integer> {
	
    @Query(value = "SELECT * FROM productos WHERE articulo LIKE %:keyword% OR ", nativeQuery = true)
    List<InventarioModel> searchByArticuloContaining(String keyword);
}
