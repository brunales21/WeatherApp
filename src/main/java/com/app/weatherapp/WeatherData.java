package com.app.weatherapp;

import java.math.BigDecimal;

/*
import lombok.Data;

@Data

 */
public class WeatherData {
    private String locationName;
    private BigDecimal temperature;
    private BigDecimal min_temperature;
    private BigDecimal max_temperature;
    private String clima;
    private int raining;
    private double windy;
    private int humidity;


    public WeatherData(String locationName, BigDecimal temperature,
                       BigDecimal min_temperature, BigDecimal max_temperature,
                       String clima, int raining, double windy, int humidity) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.min_temperature = min_temperature;
        this.max_temperature = max_temperature;
        this.clima = clima;
        this.raining = raining;
        this.windy = windy;
        this.humidity = humidity;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }
}
