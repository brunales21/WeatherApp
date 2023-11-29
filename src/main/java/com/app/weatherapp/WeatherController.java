package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {

    @FXML
    Pane pane;
    @FXML
    HBox hbox;
    private WeatherDataMediator mediator;

    public WeatherController(WeatherDataMediator mediator) {
        this.mediator = mediator;
    }

    public WeatherController() {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        try {
            FXMLLoader loader0 = new FXMLLoader(getClass().getResource("itemTemperatur.fxml"));
            Pane ventanaSecundaria0 = loader0.load();
            ItemTemperturController itemController0 = loader0.getController();
            pane.getChildren().add(ventanaSecundaria0);

            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria1 = loader1.load();
            ItemWindyController itemController1 = loader1.getController();
            hbox.getChildren().add(ventanaSecundaria1);
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria2 = loader2.load();
            ItemWindyController itemController2 = loader2.getController();
            hbox.getChildren().add(ventanaSecundaria2);
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria3 = loader3.load();
            ItemWindyController itemController3 = loader3.getController();
            hbox.getChildren().add(ventanaSecundaria3);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }




    }

    public void displayWeatherData(WeatherData weatherData) {
        // Lógica para mostrar los datos meteorológicos en la vista
    }


}
