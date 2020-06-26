package com.example.TruckerProducer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

     @Id
     private String vin;
     private String make;
     private String model;
     private int year;
     private int redlineRpm;
     private int maxFuelVolume;
     private Timestamp lastServiceDate;

}

//        {
//        "vin": "1HGCR2F3XFA027534",
//        "make": "HONDA",
//        "model": "ACCORD",
//        "year": 2015,
//        "redlineRpm": 5500,
//        "maxFuelVolume": 15,
//        "lastServiceDate": "2017-05-25T17:31:25.268Z"
//        }

