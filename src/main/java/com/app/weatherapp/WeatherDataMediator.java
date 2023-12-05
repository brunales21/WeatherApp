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


    public WeatherDataMediator() {
        this.weatherService = new WeatherService();
    }


    public void inicializeWeatherView(String localizacion)  {

        WeatherData data = weatherService.getWeatherData(localizacion);
        this.searchController=new SearchController();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("weather.fxml"));


        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),400,600);
            weatherController = fxmlLoader.getController();
            weatherController.setItems(data);
            //searchController.closeSearch();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();



        //searchController.closeSearch();
    }

}
