package com.kawaiiTokioShop.kykshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.FacturaModel;

@Repository
public interface FacturaRepository extends JpaRepository<FacturaModel, Integer> {
}
