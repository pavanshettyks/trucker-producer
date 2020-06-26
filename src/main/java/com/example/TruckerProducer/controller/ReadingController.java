package com.example.TruckerProducer.controller;

import com.example.TruckerProducer.model.Reading;
import com.example.TruckerProducer.service.ReadingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/readings")
public class ReadingController {

    private ReadingService readingService;
    @Autowired
    public ReadingController(ReadingService readingService){
        this.readingService = readingService;
    }

    @GetMapping
    @ApiOperation(value = "Get all readings")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Reading> getAllReadings(){
        return readingService.findAll();
    }

    @PostMapping
    @ApiOperation(value = "Create/Add new Alert Readings.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Added"),
            @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Reading createReading (@RequestBody Reading reading) throws JsonProcessingException {
        return readingService.save(reading);

    }

}
