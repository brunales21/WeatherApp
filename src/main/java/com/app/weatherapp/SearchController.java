package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SearchController {
    private Mediador mediador;
    @FXML
    TextField textField;
    @FXML
    ImageView searchIcon;

    public SearchController(Mediador mediator) {
        this.mediador = mediator;
    }
    @FXML
    public void onClick(MouseEvent event) {
        mediador.notifySearchCompleted(textField.getText());
    }
    public void closeSearchView() {
        Stage myStage = (Stage) this.textField.getScene().getWindow();
        myStage.close();
    }
}
