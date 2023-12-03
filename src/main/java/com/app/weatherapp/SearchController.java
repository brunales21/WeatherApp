package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchController  {

    @FXML TextField textField;
    @FXML ImageView imageView;
    static String localizacionName;
    private WeatherDataMediator mediator;

    public SearchController(){
        mediator=new WeatherDataMediator();
    }


    public SearchController(WeatherDataMediator mediator) {
        this.mediator = mediator;
    }

    @FXML
    public void onClick(MouseEvent event){
        setLocalizacionName(textField.getText());
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("weather.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(),400,600);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        closeSearch();
    }

    public void closeSearch(){
        Stage myStage = (Stage) this.textField.getScene().getWindow();
        myStage.close();
    }

    public String getLocalizacionName() {
        return localizacionName;
    }

    public void setLocalizacionName(String localizacionName) {
        this.localizacionName = localizacionName;
    }

}
