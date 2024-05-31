package com.kawaiiTokioShop.kykshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.ProductosFacturaModel;

@Repository
public interface ProductosFacturaRepository extends JpaRepository<ProductosFacturaModel, Integer> {

}