package com.app.weatherapp;

import javafx.scene.layout.Pane;

public class ItemConfig {
    private final String fxmlPath;
    private final String weatherIcon;
    private final String tipoCampo;
    private final String value;
    private final Pane parentPane;

    public ItemConfig(String fxmlPath, String weatherIcon, String tipoCampo, String value, Pane parentPane) {
        this.fxmlPath = fxmlPath;
        this.weatherIcon = weatherIcon;
        this.tipoCampo = tipoCampo;
        this.value = value;
        this.parentPane = parentPane;
    }

    public String getFxmlPath() {
        return fxmlPath;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public String getTipoCampo() {
        return tipoCampo;
    }

    public String getValue() {
        return value;
    }

    public Pane getParentPane() {
        return parentPane;
    }
}