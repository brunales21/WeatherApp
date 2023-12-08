package com.app.weatherapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchController.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 500);
        SearchController searchController = fxmlLoader.getController();
        searchController.applyGradientBackground();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.getIcons().add(new Image(String.valueOf(SearchController.class.getResource("img/iconoApp.png"))));
        stage.show();

    }
    public static void main(String[] args) {
        launch();
    }
}