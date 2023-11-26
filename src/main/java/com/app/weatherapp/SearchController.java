package com.app.weatherapp;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class SearchController {
    private WeatherDataMediator mediator;

    @FXML
    private TextField locationField;

    public SearchController(WeatherDataMediator mediator) {
        this.mediator = mediator;
    }

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

    private void onSearchEntered() throws IOException {
        String location = locationField.getText();
        mediator.onSearchEntered(location);
    }
}
