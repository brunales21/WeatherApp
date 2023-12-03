package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
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
    HBox hbox,minymax;
    WeatherDataMediator mediator = new WeatherDataMediator();
    WeatherData data;
    WeatherService weatherService= new WeatherService() ;
    //SearchController searchController;

    public WeatherController(WeatherDataMediator mediator,String localizacion) {
        this.mediator = mediator;

    }
    public WeatherController(){

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        WeatherData data1=  weatherService.getWeatherData(SearchController.localizacionName);

        try {
            FXMLLoader loader0 = new FXMLLoader(getClass().getResource("itemTemperatur.fxml"));
            Pane ventanaSecundaria0 = loader0.load();
            ItemTemperturController itemTemperturController1 = loader0.getController();
            itemTemperturController1.setValues(data1);
            pane.getChildren().add(ventanaSecundaria0);


            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria1 = loader1.load();
            ItemWindyController itemController1 = loader1.getController();
            itemController1.setTipoCampo("Viento");
            itemController1.setWeatherIcon("wind.png");
            itemController1.setValue(String.valueOf(data1.getWindy()));
            hbox.getChildren().add(ventanaSecundaria1);

            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria2 = loader2.load();
            ItemWindyController itemController2 = loader2.getController();
            itemController2.setWeatherIcon("humedad.png");
            itemController2.setTipoCampo("Humedad");
            itemController2.setValue(String.valueOf(data1.getHumidity()));
            hbox.getChildren().add(ventanaSecundaria2);

            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria3 = loader3.load();
            ItemWindyController itemController3 = loader3.getController();
            itemController3.setTipoCampo("Lluvia");
            itemController3.setWeatherIcon("gota-de-agua.png");
            itemController3.setValue(String.valueOf(data1.getRaining()));
            hbox.getChildren().add(ventanaSecundaria3);

            FXMLLoader loader4 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria4 = loader4.load();
            ItemWindyController itemController4 = loader4.getController();
            itemController4.setTipoCampo("Minima");
            itemController4.setWeatherIcon("frio.png");
            itemController4.setValue(String.valueOf(data1.getMin_temperature()));
            minymax.getChildren().add(ventanaSecundaria4);

            FXMLLoader loader5 = new FXMLLoader(getClass().getResource("itemWindyRainHumidity.fxml"));
            Pane ventanaSecundaria5 = loader5.load();
            ItemWindyController itemController5 = loader5.getController();
            itemController5.setTipoCampo("Maxima");
            itemController5.setWeatherIcon("temperatura-alta.png");
            itemController5.setValue(String.valueOf(data1.getMax_temperature()));
            minymax.getChildren().add(ventanaSecundaria5);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void close(){
        FXMLLoader fxmlLoader = new FXMLLoader(SearchController.class.getResource("search.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),300,500);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) this.pane.getScene().getWindow();
        myStage.close();

    }

    public void displayWeatherData(WeatherData weatherData) {
        String iconWeather = setIconWeather(weatherData.getIconWeather());
        //this.itemTemperturController=new ItemTemperturController(iconWeather,String.valueOf(weatherData.getTemperature()),weatherData.getLocationName());
        /*itemTemperturController.setCity(weatherData.getLocationName());

        itemTemperturController.setWeatherIcon(iconWeather);
        itemTemperturController.setDegress(String.valueOf(weatherData.getTemperature()));  */
    }

    public static String setIconWeather(String clime){
        String climaIDImage="";
        switch (clime){
            case "Rain":
                climaIDImage="rainy.png";
                break;
            case "Clear sky":
                climaIDImage="sun.png";
                break;
            case "Few clouds":
                climaIDImage="cloudy.png";
                break;
            case "Scattered clouds":
                climaIDImage="cloud.png";
                break;
            case "Broken clouds":
                climaIDImage="rainy.png";
                break;
            case "Shower rain":
                climaIDImage="rainy.png";
                break;

            case "Thunderstorm":
                climaIDImage="heavy-rain.png";
                break;
            case "Snow":
                climaIDImage="snow.png";
                break;
            case "Mist":
                climaIDImage="haze.png";
                break;


        }
        return climaIDImage;
    }

    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }
}
