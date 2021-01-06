package com.rassus.temperaturemicroservice.controllers;

import com.rassus.temperaturemicroservice.services.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class MeasurementController {

    private final MeasurementService service;

    public MeasurementController(MeasurementService service) {
        this.service = service;
    }

    @GetMapping("/current-reading")
    public ResponseEntity<?> getMeasurement() {
        return ResponseEntity.of(service.generateMeasurement());
    }
}
