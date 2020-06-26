package com.example.TruckerProducer.service;

import com.example.TruckerProducer.awsMessaging.VehicleAlertsSns;
import com.example.TruckerProducer.model.Alerts;
import com.example.TruckerProducer.model.Reading;
import com.example.TruckerProducer.model.Vehicle;
import com.example.TruckerProducer.repository.AlertsRepository;
import com.example.TruckerProducer.repository.ReadingRepository;
import com.example.TruckerProducer.repository.VehicleRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ReadingServiceImpl implements ReadingService{

    ReadingRepository readingRepository;
    AlertsRepository alertsRepository;
    VehicleRepository vehicleRepository;
    VehicleAlertsSns vehicleAlertsSns;
    ObjectMapper objectMapper;

//    RestTemplate restTemplate;

    @Autowired
    public ReadingServiceImpl(ReadingRepository readingRepository,
                              AlertsRepository alertsRepository,
                              VehicleRepository vehicleRepository,
                              VehicleAlertsSns vehicleAlertsSns,
                              ObjectMapper objectMapper){

        this.readingRepository = readingRepository;
        this.alertsRepository = alertsRepository;
        this.vehicleRepository = vehicleRepository;
        this.vehicleAlertsSns = vehicleAlertsSns;
//        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<Reading> findAll() {
        return readingRepository.findAll();
    }

    @Override
    public Reading save(Reading reading) throws JsonProcessingException {

        Optional<Vehicle> vehicle = vehicleRepository.findByVin(reading.getVin());
        if(vehicle.isPresent()){
            if(reading.getFuelVolume() < 0.1 * vehicle.get().getMaxFuelVolume()) {
                Alerts alerts = new Alerts();
                alerts.setVin(reading.getVin());
                alerts.setPriority("Medium");
                alerts.setDescription("Low Fuel");
                String message = objectMapper.writeValueAsString(alerts);
                vehicleAlertsSns.send("Low Fuel Alert",message);
                alertsRepository.save(alerts);
//                restTemplate.postForObject("http://localhost:8081/api/alerts",alerts,Alerts.class);
            }
            if(reading.getEngineRpm() > vehicle.get().getRedlineRpm()){
                Alerts alerts = new Alerts();
                alerts.setVin(reading.getVin());
                alerts.setPriority("High");
                alerts.setDescription("High RPM");
                String message = objectMapper.writeValueAsString(alerts);
                System.out.println(message);
                vehicleAlertsSns.send("High RPM Alert",message);
//                restTemplate.postForObject("http://localhost:8081/api/alerts",alerts,Alerts.class);
                alertsRepository.save(alerts);
            }
            if( (reading.getTires().getFrontLeft() < 32 )||(reading.getTires().getFrontLeft() > 36 )||
                    (reading.getTires().getFrontRight() < 32 )||(reading.getTires().getFrontRight() > 36 )||
                    (reading.getTires().getRearLeft() < 32 )||(reading.getTires().getRearLeft() > 36 )||
                    (reading.getTires().getRearRight() < 32 )||(reading.getTires().getRearRight() > 36 )
            ){
                Alerts alerts = new Alerts();
                alerts.setVin(reading.getVin());
                alerts.setPriority("Low");
                alerts.setDescription("Low/High tire pressure");
                String message = objectMapper.writeValueAsString(alerts);
                vehicleAlertsSns.send("Low/High tire pressure Alert",message);
//                restTemplate.postForObject("http://localhost:8081/api/alerts",alerts,Alerts.class);
                alertsRepository.save(alerts);
            }
            if(reading.isEngineCoolantLow() || reading.isCheckEngineLightOn()){
                Alerts alerts = new Alerts();
                alerts.setVin(reading.getVin());
                alerts.setPriority("Low");
                alerts.setDescription("Engine Coolant low or Check light On");
                String message = objectMapper.writeValueAsString(alerts);
                vehicleAlertsSns.send("Engine Coolant low or Check light On Alert",message);
//                restTemplate.postForObject("http://localhost:8081/api/alerts",alerts,Alerts.class);
                alertsRepository.save(alerts);
            }
        }
        //return readingRepository.save(reading);
        return null;
    }
}

