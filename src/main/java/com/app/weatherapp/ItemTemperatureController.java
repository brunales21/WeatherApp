package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.InputStream;

public class ItemTemperatureController {

    @FXML
    ImageView weatherIcon;
    @FXML
    Label degrees, city;

    public ItemTemperatureController(){

    }

    public void setValues(WeatherData data){
        setCity(data.getLocationName());
        setWeatherIcon(data.getIconWeather());
        setDegrees(String.valueOf(data.getTemperature()));
    }

    public void setWeatherIcon(String weather) {
        String rutaWeatherIcon = "img/"+setIconWeather(weather);
        InputStream inputStream = WeatherDataMediator.class.getResourceAsStream(rutaWeatherIcon);
        Image img = new Image(inputStream);
        weatherIcon.setImage(img);
    }

    public String setIconWeather(String clime){
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
    public void setDegrees(String value) {
        degrees.setText(value+"ºC");
    }
    public void setCity(String name) {
        city.setText(name);
    }
}
