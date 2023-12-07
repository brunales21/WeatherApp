package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    WeatherDataMediator mediator;
    @FXML
    Pane pane;
    @FXML
    HBox minymax, hbox;
    @FXML
    Label degrees, city;
    @FXML
    ImageView weatherIcon;

    public WeatherController() {
        this.mediator = new WeatherDataMediator();
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

    public void setWeatherIcon(String weather) {
        String rutaWeatherIcon = "img/"+WeatherIconMapper.getWeatherIcon(weather);
        System.out.println("ruta "+rutaWeatherIcon);
        InputStream inputStream = WeatherDataMediator.class.getResourceAsStream(rutaWeatherIcon);
        Image imagen2 = new Image(inputStream);
        weatherIcon.setImage(imagen2);
    }

    public void setItems(WeatherData data) {
        setValues(data);
        addWindyItems(data);
    }

    public void setValues(WeatherData data) {
        setCity(data.getLocationName());
        setWeatherIcon(data.getIconWeather());
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
        mediator.initSearchController();
        closeWeatherView();
    }

    public void closeWeatherView() {
        Stage stage2 = (Stage) this.pane.getScene().getWindow();
        stage2.close();
    }

    public Stage getStage() {
        return (Stage) pane.getScene().getWindow();
    }
}
