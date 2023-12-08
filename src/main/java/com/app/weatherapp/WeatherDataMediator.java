package com.app.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherDataMediator {
    private WeatherService weatherService;
    private SearchController searchController;
    private WeatherController weatherController;

    public WeatherDataMediator() {
        this.weatherService = new WeatherService();
    }

    public void initWeatherController(String localizacion) throws LocationNotFoundException {
        WeatherData data = weatherService.getWeatherData(localizacion);
        FXMLLoader fxmlLoader = new FXMLLoader(MainController.class.getResource("weather.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 600);
        } catch (IOException e) {
            //En el caso de que no cargue la ventana
            throw new RuntimeException(e);
        }
        weatherController = fxmlLoader.getController();
        weatherController.setItems(data);
        weatherController.applyGradientBackground();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(WeatherController.class.getResource("img/iconoApp.png"))));
        stage.show();
    }

    public void initSearchController() {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchController.class.getResource("search.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 500);
        } catch (IOException e) {
            //En el caso de que no cargue la ventana
            throw new RuntimeException(e);
        }
        searchController = fxmlLoader.getController();
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(SearchController.class.getResource("img/iconoApp.png"))));
        stage.show();
    }

}