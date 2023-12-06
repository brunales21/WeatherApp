package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

public class WeatherController {
    @FXML
    Pane pane;
    @FXML
    HBox minymax, hbox;
    @FXML
    Label degrees, city;
    @FXML
    ImageView weatherIcon;
    WeatherDataMediator mediator;

    public WeatherController() {
        this.mediator = new WeatherDataMediator();
    }

    public static String getIconWeather(String clime) {
        return switch (clime) {
            case "Rain", "Broken clouds", "Shower rain" -> "rainy.png";
            case "Clear sky" -> "sun.png";
            case "Few clouds" -> "cloudy.png";
            case "Scattered clouds" -> "cloud.png";
            case "Thunderstorm" -> "heavy-rain.png";
            case "Snow" -> "snow.png";
            case "Mist" -> "haze.png";
            default -> "";
        };
    }

    public void applyGradientBackground() {
        pane.getStyleClass().add(".root");
    }

    public void addWindyItems(WeatherData data) {
        List<ItemConfig> itemConfigs = Arrays.asList(new ItemConfig("itemWindyRainHumidity.fxml", "wind.png", "Viento", String.valueOf(data.getWindy()), hbox), new ItemConfig("itemWindyRainHumidity.fxml", "humedad.png", "Humedad", String.valueOf(data.getHumidity()), hbox), new ItemConfig("itemWindyRainHumidity.fxml", "gota-de-agua.png", "Lluvia", String.valueOf(data.getRaining()), hbox), new ItemConfig("itemWindyRainHumidity.fxml", "frio.png", "Minima", String.valueOf(data.getMin_temperature()), minymax), new ItemConfig("itemWindyRainHumidity.fxml", "temperatura-alta.png", "Maxima", String.valueOf(data.getMax_temperature()), minymax));
        for (ItemConfig config : itemConfigs) {
            addItem(config);
        }
    }

    private void addItem(ItemConfig config) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(config.getFxmlPath()));
            Pane ventanaSecundaria = loader.load();
            ItemWindyController itemController = loader.getController();
            itemController.setWeatherIcon(config.getWeatherIcon());
            itemController.setTipoCampo(config.getTipoCampo());
            itemController.setValue(config.getValue());
            config.getParentPane().getChildren().add(ventanaSecundaria);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setWeatherIconPath(String weather) {
        String weatherIcono = "img/"+ getIconWeather(weather);
        InputStream inputStream = WeatherDataMediator.class.getResourceAsStream(weatherIcono);
        Image imagen2 = new Image(inputStream);
        weatherIcon.setImage(imagen2);
    }

    public void setItems(WeatherData data) {
        setValues(data);
        addWindyItems(data);
    }

    public void setValues(WeatherData data) {
        setCity(data.getLocationName());
        setWeatherIconPath(data.getIconWeather());
        setDegrees(String.valueOf(data.getTemperature()));
    }

    public void setDegrees(String value) {
        degrees.setText(value+"ºC");
    }
    public void setCity(String name) {
        city.setText(name);
    }

    @FXML
    public void onClick() {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchController.class.getResource("search.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 300, 500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage1 = new Stage();
        stage1.setScene(scene);
        stage1.getIcons().add(new Image(String.valueOf(SearchController.class.getResource("img/iconoApp.png"))));
        stage1.show();

        Stage stage2 = (Stage) this.pane.getScene().getWindow();
        stage2.close();

    }

}
