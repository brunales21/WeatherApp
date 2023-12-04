package com.app.weatherapp;

import java.math.BigDecimal;

/*
import lombok.Data;

@Data

 */
public class WeatherData {
    private String locationName;
    private BigDecimal temperature;
    private BigDecimal minTemp;
    private BigDecimal maxTemp;
    private String iconWeather;
    private double raining;
    private double windy;
    private int humidity;


    public WeatherData(String locationName, BigDecimal temperature, BigDecimal min_temperature, BigDecimal max_temperature, String weather, double raining, double windy, int humidity) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.minTemp = min_temperature;
        this.maxTemp = max_temperature;
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

    public BigDecimal getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(BigDecimal minTemp) {
        this.minTemp = minTemp;
    }

    public BigDecimal getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(BigDecimal maxTemp) {
        this.maxTemp = maxTemp;
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
