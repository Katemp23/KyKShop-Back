package com.kawaiiTokioShop.kykshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kawaiiTokioShop.kykshop.models.CargoModel;
import com.kawaiiTokioShop.kykshop.repositories.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public List<CargoModel> getAllCargos() {
        return cargoRepository.findAll();
    }

    public Optional<CargoModel> getCargoById(int id) {
        return cargoRepository.findById(id);
    }

    public CargoModel saveCargo(CargoModel cargo) {
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(int id) {
        cargoRepository.deleteById(id);
    }
}
