package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class WeatherController {

    @FXML
    Pane pane;
    @FXML
    HBox hbox;
    @FXML
    HBox minymax;
    WeatherDataMediator mediator;
    ItemTemperturController itemTemperturController;

    public WeatherController() {
        this.mediator = new WeatherDataMediator();
        this.itemTemperturController = new ItemTemperturController();
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

    public void applyGradientBackground() {
        pane.getStyleClass().add(".root");
    }

    private void addItemTemperature(String fxmlPath, ItemTemperturController itemTemperturController, Pane pane, WeatherData data) {
        FXMLLoader loader0 = new FXMLLoader(getClass().getResource(fxmlPath));
        Pane ventanaSecundaria0 = null;
        try {
            ventanaSecundaria0 = loader0.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        itemTemperturController = loader0.getController();
        itemTemperturController.setValues(data);
        pane.getChildren().add(ventanaSecundaria0);
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

    public void setItems(WeatherData data) {
        addItemTemperature("itemTemperature.fxml", itemTemperturController, pane, data);
        addWindyItems(data);
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
