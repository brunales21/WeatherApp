package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

import static com.app.weatherapp.WeatherController.setIconWeather;

public class ItemWindyController {

    @FXML
    Label value,tipoCampo;
    @FXML
    ImageView weatherIcon;

    public Label getValue() {
        return value;
    }

    public void setValue(String valor) {
        value.setText(valor);
    }

    public Label getTipoCampo() {
        return tipoCampo;
    }

    public void setTipoCampo(String tipo) {
        tipoCampo.setText(tipo);
    }

    public ImageView getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weather) {
        String weatherIcono = "img/"+weather;
        InputStream inputStream = WeatherDataMediator.class.getResourceAsStream(weatherIcono);
        Image imagen2 = new Image(inputStream);
        weatherIcon.setImage(imagen2);
    }
}
