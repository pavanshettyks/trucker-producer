package com.example.TruckerProducer.service;

import com.example.TruckerProducer.model.Reading;
import com.example.TruckerProducer.model.Vehicle;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;
import java.util.Optional;

public interface ReadingService {

    List<Reading> findAll();

    Reading save(Reading reading) throws JsonProcessingException;
}

