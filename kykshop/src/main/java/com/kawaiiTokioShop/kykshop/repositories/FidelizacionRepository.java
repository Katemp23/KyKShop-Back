package com.kawaiiTokioShop.kykshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.FidelizacionModel;

@Repository
public interface FidelizacionRepository extends JpaRepository<FidelizacionModel, Integer> {
}