package com.app.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class WeatherDataMediator {
    private final WeatherService weatherService;
    private SearchController searchController;
    private WeatherController weatherController;



    public WeatherDataMediator() {
        this.weatherService = new WeatherService();
    }

    public void initWeatherController(String localizacion) throws LocationNotFoundException {
        WeatherData data = weatherService.getWeatherData(localizacion);
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("weather.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 400, 600);
            weatherController = fxmlLoader.getController();
            weatherController.setItems(data);
            weatherController.applyGradientBackground();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(WeatherController.class.getResource("img/iconoApp.png"))));
        stage.show();
    }

    public void initSearchController() {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchController.class.getResource("search.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 500);
            searchController = fxmlLoader.getController();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.getIcons().add(new Image(String.valueOf(SearchController.class.getResource("img/iconoApp.png"))));
        stage.show();
    }

    public void closeSearchView() {
        if (searchController != null && searchController.getStage() != null) {
            searchController.getStage().close();
        }
    }

    public void closeWeatherView() {
        if (weatherController != null && weatherController.getStage() != null) {
            weatherController.getStage().close();
        }
    }
}