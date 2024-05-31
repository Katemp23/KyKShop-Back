package com.kawaiiTokioShop.kykshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kawaiiTokioShop.kykshop.models.CargoModel;

@Repository
public interface CargoRepository extends JpaRepository<CargoModel, Integer> {
}
