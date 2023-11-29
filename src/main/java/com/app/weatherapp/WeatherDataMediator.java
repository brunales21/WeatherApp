package com.app.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

    public void inicializeWeatherView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("weather.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),400,600);
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public WeatherData buscarApi(String localizacion) throws IOException {
       WeatherData datos =  weatherService.getWeatherData(localizacion);
       return datos;
    }

    public void onSearchEntered(String location) throws IOException {
        // Lógica de coordinación entre los componentes y la API
        WeatherData weatherData = weatherService.getWeatherData(location);
        weatherController.displayWeatherData(weatherData);
    }


}
