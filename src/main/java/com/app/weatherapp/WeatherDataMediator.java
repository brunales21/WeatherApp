package com.app.weatherapp;

import java.io.IOException;

public class WeatherDataMediator {
    private WeatherService weatherService;
    private SearchController searchController;
    private WeatherController weatherController;

    public WeatherDataMediator() {
        this.weatherService = new WeatherService();
    }

    public void registerSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void registerWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    public void onSearchEntered(String location) throws IOException {
        // Lógica de coordinación entre los componentes y la API
        WeatherData weatherData = weatherService.getWeatherData(location);
        weatherController.displayWeatherData(weatherData);
    }
}
