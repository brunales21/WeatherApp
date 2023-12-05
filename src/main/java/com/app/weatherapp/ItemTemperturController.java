package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class ItemTemperturController {

    @FXML
    ImageView weatherIcon;
    @FXML
    Label degrees,city;

    public ItemTemperturController() {

    }
    public void setValues(WeatherData data){
        setCity(data.getLocationName());
        setWeatherIconPath(data.getIconWeather());
        setDegrees(String.valueOf(data.getTemperature()));
    }
    public static String setIconWeather(String clime){
        String climaIDImage="";
        switch (clime){
            case "Rain":
            case "Drizzle":
                climaIDImage="rainy.png";
                break;
            case "Clear":
                climaIDImage="sun.png";
                break;
            case "Clouds":
                climaIDImage="cloudy.png";
                break;
            case "Thunderstorm":
                climaIDImage="heavy-rain.png";
                break;
            case "Snow":
                climaIDImage="snow.png";
                break;
            case "Mist":
            case "Smoke":
            case "Haze":
            case "Dust":
            case "Fog":
            case "Sand":
            case "Ash":
            case "Squall":
            case "Tornado":
                climaIDImage="haze.png";
                break;


        }
        return climaIDImage;
    }
    public void setWeatherIconPath(String weather) {
        String weatherIcono = "img/"+setIconWeather(weather);
        InputStream inputStream = WeatherDataMediator.class.getResourceAsStream(weatherIcono);
        Image imagen2 = new Image(inputStream);
        weatherIcon.setImage(imagen2);
    }
    public void setDegrees(String value) {
        degrees.setText(value+"ºC");
    }
    public void setCity(String name) {
        city.setText(name);
    }
}
