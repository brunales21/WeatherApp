package com.app.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        WeatherDataMediator mediator = new WeatherDataMediator();

        FXMLLoader searchLoader = new FXMLLoader(getClass().getResource("search.fxml"));
        FXMLLoader weatherLoader = new FXMLLoader(getClass().getResource("weather.fxml"));

        // Load controllers with the mediator
        SearchController searchController = new SearchController(mediator);
        WeatherController weatherController = new WeatherController(mediator);

        searchLoader.setController(searchController);
        weatherLoader.setController(weatherController);

        Pane searchPane = searchLoader.load();
        Pane weatherPane = weatherLoader.load();

        mediator.registerSearchController(searchController);
        mediator.registerWeatherController(weatherController);

        Scene searchScene = new Scene(searchPane, 400, 600);
        Scene weatherScene = new Scene(weatherPane, 400, 600);

        stage.setScene(searchScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}