package com.rassus.temperaturemicroservice.repositories;

import com.rassus.temperaturemicroservice.domain.entities.Measurement;
import org.springframework.data.repository.CrudRepository;

public interface MeasurementRepository extends CrudRepository<Measurement, Long> {
}
