package com.app.weatherapp;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;

public class WeatherDataMediator {
    private WeatherService weatherService;
    private SearchController searchController;
    private WeatherController weatherController;
    private String localizacion;

    public WeatherDataMediator() {
        this.weatherService = new WeatherService();
    }

   /* public void registerSearchController(SearchController searchController) {
        this.searchController = searchController;
    }

    public void registerWeatherController(WeatherController weatherController) {
        this.weatherController = weatherController;
    }

    */

    public void inicializeWeatherView(String localizacion)  {

        this.weatherController=new WeatherController();
        this.searchController=new SearchController();

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("weather.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),400,600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

}
