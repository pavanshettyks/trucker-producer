package com.example.TruckerProducer.repository;

import com.example.TruckerProducer.model.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends JpaRepository<Reading,String> {
}
