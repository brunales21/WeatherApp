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
    private String iconWeather;
    private double raining;
    private double windy;
    private int humidity;


    public WeatherData(String locationName, BigDecimal temperature,
                       BigDecimal min_temperature, BigDecimal max_temperature,
                       String weather, double raining, double windy, int humidity) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.min_temperature = min_temperature;
        this.max_temperature = max_temperature;
        this.iconWeather = weather;
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

    public BigDecimal getMin_temperature() {
        return min_temperature;
    }

    public void setMin_temperature(BigDecimal min_temperature) {
        this.min_temperature = min_temperature;
    }

    public BigDecimal getMax_temperature() {
        return max_temperature;
    }

    public void setMax_temperature(BigDecimal max_temperature) {
        this.max_temperature = max_temperature;
    }

    public String getIconWeather() {
        return iconWeather;
    }

    public void setIconWeather(String iconWeather) {
        this.iconWeather = iconWeather;
    }

    public double getRaining() {
        return raining;
    }

    public void setRaining(double raining) {
        this.raining = raining;
    }

    public double getWindy() {
        return windy;
    }

    public void setWindy(double windy) {
        this.windy = windy;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
