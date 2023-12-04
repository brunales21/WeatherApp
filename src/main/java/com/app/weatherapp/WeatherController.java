package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WeatherController implements Initializable {
    @FXML
    Pane pane;
    @FXML
    HBox hbox, minymax;
    private Mediador mediador;
    private WeatherData weatherData;
    private WeatherService weatherService;

    public WeatherController(Mediador mediador) {
        this.mediador = mediador;
        this.weatherService = new WeatherService();
    }


    public static String setIconWeather(String clime) {
        String climaIDImage = switch (clime) {
            case "Rain" -> "rainy.png";
            case "Clear sky" -> "sun.png";
            case "Few clouds" -> "cloudy.png";
            case "Scattered clouds" -> "cloud.png";
            case "Broken clouds" -> "rainy.png";
            case "Shower rain" -> "rainy.png";
            case "Thunderstorm" -> "heavy-rain.png";
            case "Snow" -> "snow.png";
            case "Mist" -> "haze.png";
            default -> "";
        };
        return climaIDImage;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loader0 = new FXMLLoader(getClass().getResource("itemTemperatur.fxml"));
            Pane ventanaSecundaria0 = loader0.load();
            ItemTemperatureController itemTemperturController1 = loader0.getController();
            itemTemperturController1.setValues(weatherData);
            pane.getChildren().add(ventanaSecundaria0);

            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria1 = loader1.load();
            ItemWindyController itemController1 = loader1.getController();
            itemController1.setTipoCampo("Viento");
            itemController1.setWeatherIcon("wind.png");
            itemController1.setValue(String.valueOf(weatherData.getWindy()));
            hbox.getChildren().add(ventanaSecundaria1);

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria2 = loader2.load();
            ItemWindyController itemController2 = loader2.getController();
            itemController2.setWeatherIcon("humedad.png");
            itemController2.setTipoCampo("Humedad");
            itemController2.setValue(String.valueOf(weatherData.getHumidity()));
            hbox.getChildren().add(ventanaSecundaria2);

            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria3 = loader3.load();
            ItemWindyController itemController3 = loader3.getController();
            itemController3.setTipoCampo("Lluvia");
            itemController3.setWeatherIcon("gota-de-agua.png");
            itemController3.setValue(String.valueOf(weatherData.getRaining()));
            hbox.getChildren().add(ventanaSecundaria3);

            FXMLLoader loader4 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria4 = loader4.load();
            ItemWindyController itemController4 = loader4.getController();
            itemController4.setTipoCampo("Minima");
            itemController4.setWeatherIcon("frio.png");
            itemController4.setValue(String.valueOf(weatherData.getMinTemp()));
            minymax.getChildren().add(ventanaSecundaria4);

            FXMLLoader loader5 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria5 = loader5.load();
            ItemWindyController itemController5 = loader5.getController();
            itemController5.setTipoCampo("Maxima");
            itemController5.setWeatherIcon("temperatura-alta.png");
            itemController5.setValue(String.valueOf(weatherData.getMaxTemp()));
            minymax.getChildren().add(ventanaSecundaria5);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void close(MouseEvent event) {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.close();
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }
}
