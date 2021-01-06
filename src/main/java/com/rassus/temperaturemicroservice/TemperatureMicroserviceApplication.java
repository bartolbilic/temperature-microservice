package com.rassus.temperaturemicroservice;

import com.rassus.temperaturemicroservice.domain.entities.Measurement;
import com.rassus.temperaturemicroservice.services.MeasurementService;
import com.rassus.temperaturemicroservice.utils.MeasurementReader;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class TemperatureMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureMicroserviceApplication.class, args);
    }
}
