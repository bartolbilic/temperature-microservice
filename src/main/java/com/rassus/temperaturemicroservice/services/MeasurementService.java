package com.rassus.temperaturemicroservice.services;

import com.rassus.temperaturemicroservice.domain.entities.Measurement;
import com.rassus.temperaturemicroservice.repositories.MeasurementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpStatusCodeException;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Slf4j
public class MeasurementService {

    private final MeasurementRepository repository;

    public MeasurementService(MeasurementRepository repository) {
        this.repository = repository;
    }

    public void save(Measurement measurement) {
        repository.save(measurement);
        log.info("Saved measurement: {}", measurement);
    }

    public Optional<Measurement> generateMeasurement() {
        return repository.findById(generateMeasurementId());
    }

    private Long generateMeasurementId() {
        LocalDateTime dateTime = LocalDateTime.now();
        int hours = dateTime.getHour();
        int minutes = dateTime.getMinute();

        return (long) (4 * hours + (minutes / 15) + 1);
    }
}
