package com.rassus.temperaturemicroservice.utils;

import com.rassus.temperaturemicroservice.domain.entities.Measurement;
import com.rassus.temperaturemicroservice.services.MeasurementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
public class InitializingBeanExample implements InitializingBean {

    private final MeasurementService service;

    public InitializingBeanExample(MeasurementService service) {
        this.service = service;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        MeasurementReader reader = new MeasurementReader();
        List<Measurement> measurements = reader.getMeasurements();
        for (Measurement measurement : measurements) {
            service.save(measurement);
        }
    }
}