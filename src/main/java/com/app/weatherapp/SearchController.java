package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private WeatherDataMediator mediator;

    public SearchController(){
        mediator=new WeatherDataMediator();
    }


    public SearchController(WeatherDataMediator mediator) {
        this.mediator = mediator;
    }

    @FXML
    public  void onClick(MouseEvent event) throws IOException {
        //mediator.buscarApi(textField.getText());
        mediator.inicializeWeatherView();
        Stage myStage = (Stage) this.textField.getScene().getWindow();
        myStage.close();
    }



    /*
    @FXML
    private void initialize() {
        locationField.setOnAction(event -> {
            try {
                onSearchEntered();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

     */

    /*
    private void onSearchEntered() throws IOException {
        String location = locationField.getText();
        mediator.onSearchEntered(location);
    }

     */
}
