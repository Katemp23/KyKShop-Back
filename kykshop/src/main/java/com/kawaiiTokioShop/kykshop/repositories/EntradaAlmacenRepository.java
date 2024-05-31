package com.kawaiiTokioShop.kykshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.EntradaAlmacenModel;

@Repository
public interface EntradaAlmacenRepository extends JpaRepository<EntradaAlmacenModel, Integer> {
}
