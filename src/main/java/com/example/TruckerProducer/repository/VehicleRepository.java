package com.example.TruckerProducer.repository;

import com.example.TruckerProducer.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,String> {

    public Optional<Vehicle> findByVin(String Vin);
}
