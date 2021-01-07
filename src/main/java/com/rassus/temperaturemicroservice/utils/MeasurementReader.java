package com.rassus.temperaturemicroservice.utils;

import com.rassus.temperaturemicroservice.domain.entities.Measurement;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Slf4j
public class MeasurementReader {
    private static List<Measurement> measurements;

    public List<Measurement> getMeasurements() {
        if (measurements == null || measurements.isEmpty()) {
            return parseLineToMeasurements();
        }

        return measurements;
    }

    private List<Measurement> parseLineToMeasurements() {
        List<Measurement> measurements = new ArrayList<>();
        List<String> lines = readAllLines();

        if (lines == null) {
            log.info("Measurements don't exist!");
        }

        for (String line : lines) {
            Float value = Float.parseFloat(line.split(",")[0]);
            measurements.add(new Measurement("Temperature", value));
        }

        return measurements;
    }

    private List<String> readAllLines() {
        String line = null;
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream("data.csv"))))) {
            reader.readLine();

            for (int i = 0; i <= 99; i++) {
                line = reader.readLine();
                lines.add(line);
            }
        } catch (Exception e) {
            log.error("Error occurred: " + e.getMessage());
        }

        return lines;
    }
}