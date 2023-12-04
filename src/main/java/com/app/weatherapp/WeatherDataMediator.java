package com.app.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherDataMediator implements Mediador {
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

    public void inicializeWeatherView() {
        // Verificar si ya existe una instancia de WeatherController
        if (weatherController == null) {
            // Crear una nueva instancia de WeatherController
            weatherController = new WeatherController(this);
        }

        // Verificar si ya existe una instancia de SearchController
        if (searchController == null) {
            // Crear una nueva instancia de SearchController
            searchController = new SearchController(this);
        }

        // Configurar el FXMLLoader para cargar la vista FXML del clima
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("weather.fxml"));
        try {
            Scene scene = new Scene(fxmlLoader.load(), 400, 600);

            // Configurar el escenario (Stage) para mostrar la vista
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Error al cargar la vista del clima", e);
        }
    }

    @Override
    public void notifySearchCompleted(String location) {
        WeatherData weatherData = weatherService.getWeatherData(location);
        notifyWeatherDataChanged(weatherData);
        inicializeWeatherView();
        searchController.closeSearchView();
    }


    @Override
    public void notifyWeatherDataChanged(WeatherData data) {
        weatherController.setWeatherData(data);
    }

    @Override
    public void notifyWeatherControllerClosed() {
        searchController.closeSearchView();
    }

    public WeatherService getWeatherService() {
        return weatherService;
    }

    public SearchController getSearchController() {
        return searchController;
    }

    public WeatherController getWeatherController() {
        return weatherController;
    }
}
