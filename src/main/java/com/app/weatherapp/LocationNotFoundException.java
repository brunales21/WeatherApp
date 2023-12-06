package com.app.weatherapp;

public class LocationNotFoundException extends Exception {
    public LocationNotFoundException(String location) {
        super("Localización no encontrada: "+location);
    }
}
