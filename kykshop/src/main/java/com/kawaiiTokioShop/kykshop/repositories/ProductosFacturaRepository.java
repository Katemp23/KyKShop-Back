package com.kawaiiTokioShop.kykshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.ProductosFacturaModel;

@Repository
public interface ProductosFacturaRepository extends JpaRepository<ProductosFacturaModel, Integer> {
	
	public abstract List<ProductosFacturaModel> findByIdFactura(int idFactura);

}