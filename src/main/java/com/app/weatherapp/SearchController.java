package com.app.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class SearchController {

    @FXML TextField textField;
    @FXML ImageView imageView;
    @FXML AnchorPane panelPrincipal;
    private WeatherDataMediator mediator;

    public SearchController(){
        mediator=new WeatherDataMediator();
    }

    @FXML
    public void onClick(MouseEvent event){
        mediator.inicializeWeatherView(textField.getText());
        closeSearch();
    }

    public void closeSearch(){
        Stage myStage = (Stage) this.textField.getScene().getWindow();
        myStage.close();
    }


}
