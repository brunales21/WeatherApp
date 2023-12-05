package com.app.weatherapp;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ErrorDialog extends Stage {

    public ErrorDialog(String errorMessage) {
        initStyle(StageStyle.UTILITY);
        initModality(Modality.APPLICATION_MODAL);

        VBox vbox = new VBox();
        vbox.getChildren().add(new Label(errorMessage));

        Scene scene = new Scene(vbox, 250, 100);
        setScene(scene);
    }
}
