package com.app.weatherapp;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class WeatherService {

    private static final String API_KEY = "c37f27d3b5efe8d856bf0e9fa36fc1ae";  // Reemplaza con tu clave de API
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final HttpClient httpClient = HttpClient.newHttpClient();



    public WeatherData getWeatherData(String location) throws LocationNotFoundException {
        String encodedLocation = null;
        try {
            encodedLocation = URLEncoder.encode(location, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String requestUrl = API_URL + "?q=" + encodedLocation + "&appid=" + API_KEY;

        URI uri = null;
        try {
            uri = new URI(requestUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Manejar el código de respuesta
        int statusCode = response.statusCode();
        if (statusCode == 404) {
            // Localización no encontrada, lanzar una excepción específica
            throw new LocationNotFoundException("Localización no encontrada: " + location);
        } else if (statusCode != 200) {
            throw new RuntimeException("Error al obtener datos meteorológicos");
        }


        JSONObject json = new JSONObject(response.body());
        System.out.println(json);
        JSONArray weather = json.getJSONArray("weather");
        JSONObject valorClima = weather.getJSONObject(0);
        String icon = valorClima.getString("main");

        //Temperatura tranformada a celsius
        JSONObject temp= json.getJSONObject("main");
        BigDecimal temperatura = temp.getBigDecimal("temp");
        temperatura = temperatura.subtract(BigDecimal.valueOf(273.15));

        BigDecimal temperaturaMaxima = temp.getBigDecimal("temp_max");
        temperaturaMaxima = temperaturaMaxima.subtract(BigDecimal.valueOf(273.15));

        BigDecimal temperaturaMinima = temp.getBigDecimal("temp_min");
        temperaturaMinima = temperaturaMinima.subtract(BigDecimal.valueOf(273.15));


        //Viento tranformado a km/h
        JSONObject viento= json.getJSONObject("wind");
        double wind = viento.getInt("speed");
        wind = wind*3.6;

        int humidity = temp.getInt("humidity");

        JSONObject valorLLuvia;
        double lluvia = 0;
        try {
            if ((valorLLuvia=json.getJSONObject("rain"))!=null) {
                lluvia = valorLLuvia.getDouble("1h");
                System.out.println(lluvia);
            }

        }catch (JSONException e){
            lluvia=0;
        }

            // Como ejemplo, crearemos un objeto WeatherData con valores predeterminados
        WeatherData weatherData = new WeatherData(location,temperatura,temperaturaMinima,temperaturaMaxima,icon,lluvia,wind,humidity);
        return weatherData;
    }
}
