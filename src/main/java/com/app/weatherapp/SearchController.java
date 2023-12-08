package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchController {
    @FXML private TextField textField;
    @FXML private AnchorPane panelPrincipal;
    private final WeatherDataMediator mediator;
    public SearchController() {
        mediator = new WeatherDataMediator();
    }
    @FXML
    private void onClick(MouseEvent event) {
        try {
            mediator.initWeatherController(textField.getText());
            closeSearchView();
        } catch (LocationNotFoundException e) {
            // Muestra una ventana de error con el mensaje de la excepción.
            ErrorDialog errorDialog = new ErrorDialog(e.getMessage());
            errorDialog.showAndWait();
            vaciarTextField();
        }
    }

    public void applyGradientBackground() {
        panelPrincipal.getStyleClass().add(".root");
    }

    private void vaciarTextField() {
        textField.setText("");
    }

    private void closeSearchView() {
        Stage myStage = (Stage) this.textField.getScene().getWindow();
        myStage.close();
    }
}
