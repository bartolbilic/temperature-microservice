package com.rassus.temperaturemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class TemperatureMicroserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TemperatureMicroserviceApplication.class, args);
    }
}
