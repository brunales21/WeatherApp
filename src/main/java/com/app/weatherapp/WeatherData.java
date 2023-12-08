package com.app.weatherapp;

import java.math.BigDecimal;

public class WeatherData {
    private String locationName;
    private BigDecimal temperature;
    private BigDecimal minTemperature;
    private BigDecimal maxTemperature;
    private String iconWeather;
    private double raining;
    private double windy;
    private int humidity;


    public WeatherData(String locationName, BigDecimal temperature,
                       BigDecimal minTemperature, BigDecimal maxTemperature,
                       String weather, double raining, double windy, int humidity) {
        this.locationName = locationName;
        this.temperature = temperature;
        this.minTemperature = minTemperature;
        this.maxTemperature = maxTemperature;
        this.iconWeather = weather;
        this.raining = raining;
        this.windy = windy;
        this.humidity = humidity;
    }

    public String getLocationName() {
        return locationName;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public BigDecimal getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(BigDecimal minTemperature) {
        this.minTemperature = minTemperature;
    }

    public BigDecimal getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(BigDecimal maxTemperature) {
        this.maxTemperature = maxTemperature;
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
