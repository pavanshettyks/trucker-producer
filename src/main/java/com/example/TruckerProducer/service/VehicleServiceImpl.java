package com.example.TruckerProducer.service;

import com.example.TruckerProducer.model.Vehicle;
import com.example.TruckerProducer.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService{

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Optional<Vehicle> findById(String vin) throws Exception {
        Optional<Vehicle> current = vehicleRepository.findByVin(vin);
        if(!current.isPresent()){
            throw new Exception("Employee with id= "+vin+" NOT FOUND");
        }
        return current;
    }

    @Override
    public List<Vehicle> update(List<Vehicle> vehicles) {


        return vehicleRepository.saveAll(vehicles);
    }
}
