package com.kawaiiTokioShop.kykshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.CiudadModel;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadModel, String> {
}
