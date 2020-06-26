package com.example.TruckerProducer.controller;

import com.example.TruckerProducer.model.Vehicle;
import com.example.TruckerProducer.service.VehicleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/vehicles")
public class VehicleController {


    private VehicleService vehicleService;
    @Autowired
    public VehicleController(VehicleService vehicleService){
        this.vehicleService = vehicleService;
    }

    @GetMapping
    @ApiOperation(value = "Get all vehicles")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> getAllVehicles(){
        return vehicleService.findAll();
    }

    @GetMapping(value = "{vin}")
    @ApiOperation(value = "Get vehicle by Vin")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Optional<Vehicle> getVehicleByVin(@PathVariable("vin")  String vin) throws Exception {
        return vehicleService.findById(vin);
    }

    @PutMapping
    @ApiOperation(value = "Add/update vehicles")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Vehicle> createVehicles(@RequestBody List<Vehicle> vehicles){
        return vehicleService.update(vehicles);

    }



}
