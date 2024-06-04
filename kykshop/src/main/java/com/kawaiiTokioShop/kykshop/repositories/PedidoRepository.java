package com.kawaiiTokioShop.kykshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.PedidoModel;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoModel, Integer> {
	
	public abstract List<PedidoModel> findByIdPersona(int idPersona);
}