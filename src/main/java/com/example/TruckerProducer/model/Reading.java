package com.example.TruckerProducer.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
public class Reading {
    @Id
    private String id;
    private String vin;
    private String latitude;
    private String longitude;
    private int speed;
    private int fuelVolume;
    private int engineHp;
    private int engineRpm;
    private boolean checkEngineLightOn;
    private boolean engineCoolantLow;
    private boolean cruiseControlOn;
    private Timestamp timestamp;

    @OneToOne(fetch= FetchType.EAGER,
            cascade =  CascadeType.ALL)
    private Tires tires;

    public Reading(){
        this.id = UUID.randomUUID().toString();
    }

}
