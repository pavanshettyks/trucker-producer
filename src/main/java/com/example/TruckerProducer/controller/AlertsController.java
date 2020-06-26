package com.example.TruckerProducer.controller;

import com.example.TruckerProducer.model.Alerts;
import com.example.TruckerProducer.service.AlertsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/alerts")
public class AlertsController {

    private AlertsService alertsService;

    @Autowired
    AlertsController(AlertsService alertsService){
        this.alertsService = alertsService;
    }

    @GetMapping
    @ApiOperation(value = "Reading alerts is being deprecated. Use TruckerConsumer")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Alerts> findAll(@RequestParam(value = "priority", required = false) String priority,
                                @RequestParam(value = "vin", required = false) String vin){
//        if(vin == null && priority == null){
//            return alertsService.findAll();
//        }
//        else if(vin == null){
//            return alertsService.findByPriority(priority);
//        }
//        else if( priority == null){
//            return alertsService.findByVin(vin);
//        }
//        return alertsService.findByVinAndPriority(vin,priority);
        return null;
    }



}
