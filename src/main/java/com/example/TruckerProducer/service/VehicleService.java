package com.example.TruckerProducer.service;

import com.example.TruckerProducer.model.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {

    List<Vehicle> findAll();

    Optional<Vehicle> findById(String vin) throws Exception;

    List<Vehicle> update(List<Vehicle> vehicles);

}
