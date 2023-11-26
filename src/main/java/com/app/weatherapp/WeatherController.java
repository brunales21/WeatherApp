package com.app.weatherapp;

import javafx.fxml.FXML;

public class WeatherController {

    private WeatherDataMediator mediator;

    public WeatherController(WeatherDataMediator mediator) {
        this.mediator = mediator;
    }

    public WeatherController() {
    }

    @FXML
    private void initialize() {
        // Lógica de inicialización si es necesaria
    }

    public void displayWeatherData(WeatherData weatherData) {
        // Lógica para mostrar los datos meteorológicos en la vista
    }
}
