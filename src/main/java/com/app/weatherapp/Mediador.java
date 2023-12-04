package com.app.weatherapp;

public interface Mediador {
    void notifySearchCompleted(String location);
    void notifyWeatherDataChanged(WeatherData data);
    void notifyWeatherControllerClosed();

}
