package com.example.TruckerProducer.repository;

import com.example.TruckerProducer.model.Alerts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertsRepository extends JpaRepository<Alerts,String> {

    public List<Alerts> findAllByVinAndPriority(String vin, String priority);

    public List<Alerts> findAllByPriority(String priority);

    public List<Alerts> findAllByVin(String vin);
}
