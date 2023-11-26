package com.app.weatherapp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class WeatherService {
    private static final String API_KEY = "your_api_key";  // Reemplaza con tu clave de API
    private static final String API_URL = "https://api.weatherapi.com/v1/current.json";

    private final OkHttpClient httpClient = new OkHttpClient();

    public WeatherData getWeatherData(String location) throws IOException {
        String requestUrl = API_URL + "?key=" + API_KEY + "&q=" + location;
        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Aquí parsear la respuesta JSON y devolver un objeto WeatherData
            // Ejemplo:
            // WeatherData weatherData = parseJsonResponse(response.body().string());
            // return weatherData;

            // Como ejemplo, crearemos un objeto WeatherData con valores predeterminados
            WeatherData weatherData = new WeatherData();
            weatherData.setLocation(location);
            weatherData.setTemperature("25°C");
            return weatherData;
        }
    }

    // Método para parsear la respuesta JSON y construir un objeto WeatherData
    private WeatherData parseJsonResponse(String jsonResponse) {
        // Implementar lógica de parsing aquí
        return null;
    }
}
