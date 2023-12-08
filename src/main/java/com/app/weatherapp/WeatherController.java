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
    private WeatherDataMediator mediator;
    @FXML private Pane pane;
    @FXML private HBox minymax, hbox;
    @FXML private Label degrees, city;
    @FXML private ImageView weatherIcon;

    public WeatherController() {
        this.mediator = new WeatherDataMediator();
    }
    @FXML
    private void onClick() {
        mediator.initSearchController();
        closeWeatherView();
    }
    public void setItems(WeatherData data) {
        setValues(data);
        addWindyItems(data);
    }
    public void applyGradientBackground() {
        pane.getStyleClass().add(".root");
    }
    private void addWindyItems(WeatherData data) {
        List<ItemConfig> itemConfigs = Arrays.asList(
                new ItemConfig("weatherItem.fxml", "wind.png", "Viento",(roundValue(data.getWindy())+" km/h"), hbox),
                new ItemConfig("weatherItem.fxml", "humedad.png", "Humedad",(roundValue(data.getHumidity())+"%"), hbox),
                new ItemConfig("weatherItem.fxml", "gotas.png", "Lluvia", (roundValue(data.getRaining())+"%"), hbox),
                new ItemConfig("weatherItem.fxml", "baja-temperatura.png", "Minima", roundValue(Double.parseDouble(String.valueOf(data.getMinTemperature()))), minymax),
                new ItemConfig("weatherItem.fxml", "caliente.png", "Maxima",roundValue(Double.parseDouble(String.valueOf(data.getMaxTemperature()))), minymax));
        for (ItemConfig config : itemConfigs) {
            addItem(config);
        }
    }
    private void addItem(ItemConfig config) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(config.getFxmlPath()));
        Pane ventanaSecundaria = null;
        try {
            ventanaSecundaria = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ItemController itemController = loader.getController();
        itemController.setWeatherIcon(config.getWeatherIcon());
        itemController.setTipoCampo(config.getTipoCampo());
        itemController.setValue(config.getValue());
        config.getParentPane().getChildren().add(ventanaSecundaria);
    }
    private void setValues(WeatherData data) {
        setCity(data.getLocationName());
        setWeatherIcon(data.getIconWeather());
        setDegrees(String.valueOf(data.getTemperature()));
    }
    private void setWeatherIcon(String weather) {
        String rutaWeatherIcon = "img/"+WeatherIconMapper.getWeatherIcon(weather);
        System.out.println("ruta "+rutaWeatherIcon);
        InputStream inputStream = WeatherDataMediator.class.getResourceAsStream(rutaWeatherIcon);
        Image imagen2 = new Image(inputStream);
        weatherIcon.setImage(imagen2);
    }
    private void setDegrees(String value) {
        int valor = Math.round(Float.parseFloat(value));
        degrees.setText(valor+"ºC");
    }
    private void setCity(String name) {
        String ciudad = String.valueOf(name.charAt(0)).toUpperCase();
        ciudad=ciudad+name.substring(1,name.length());
        city.setText(ciudad);
    }
    private void closeWeatherView() {
        Stage stage2 = (Stage) this.pane.getScene().getWindow();
        stage2.close();
    }
    private String roundValue(double decimal){
        String valor = String.valueOf(decimal);
        String valorRedondeado= String.valueOf(Math.round(Float.parseFloat(valor)));
        return valorRedondeado;
    }
}
