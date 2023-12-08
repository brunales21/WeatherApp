package com.app.weatherapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;


public class WeatherService {
    private static final String API_KEY = "c37f27d3b5efe8d856bf0e9fa36fc1ae";  // Reemplaza con tu clave de API
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final HttpClient httpClient = HttpClient.newHttpClient();

    //Realiza un get a una api de la localizacion pasada por parametro y devuelve un objeto weather data
    public WeatherData getWeatherData(String location) throws LocationNotFoundException {
        if (location.isBlank()) {
            throw new LocationNotFoundException("");
        }
        String encodedLocation = URLEncoder.encode(location, StandardCharsets.UTF_8);
        String requestUrl = API_URL + "?q=" + encodedLocation + "&appid=" + API_KEY;

        URI uri = null;
        try {
            uri = new URI(requestUrl);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        HttpRequest request = HttpRequest.newBuilder().uri(uri).GET().build();

        HttpResponse<String> response = null;
        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Manejar el código de respuesta
        int statusCode = response.statusCode();
        if (statusCode == 404) {
            //Localización no encontrada
            throw new LocationNotFoundException(location);
        } else if (statusCode != 200) {
            throw new RuntimeException("Error al obtener datos meteorológicos");
        }

        JSONObject json = new JSONObject(response.body());
        System.out.println(json);
        JSONArray weather = json.getJSONArray("weather");
        JSONObject valorClima = weather.getJSONObject(0);
        String icon = valorClima.getString("main");

        //Temperatura tranformada a celsius
        JSONObject temp = json.getJSONObject("main");
        BigDecimal temperatura = temp.getBigDecimal("temp");
        temperatura = temperatura.subtract(BigDecimal.valueOf(273.15));

        BigDecimal temperaturaMaxima = temp.getBigDecimal("temp_max");
        temperaturaMaxima = temperaturaMaxima.subtract(BigDecimal.valueOf(273.15));

        BigDecimal temperaturaMinima = temp.getBigDecimal("temp_min");
        temperaturaMinima = temperaturaMinima.subtract(BigDecimal.valueOf(273.15));

        //Viento tranformado a km/h
        JSONObject viento = json.getJSONObject("wind");
        double wind = viento.getInt("speed");
        wind = wind * 3.6;

        int humidity = temp.getInt("humidity");

        JSONObject valorLLuvia;
        double lluvia = 0;
        try {
            if ((valorLLuvia = json.getJSONObject("rain")) != null) {
                lluvia = valorLLuvia.getDouble("1h");
                System.out.println(lluvia);
            }
        } catch (JSONException e) {
            //Lanzara esta excepcion cuando la localizacion no tenga precipitaciones
            lluvia = 0;
        }

        return new WeatherData(location, temperatura, temperaturaMinima, temperaturaMaxima,
                icon, lluvia, wind, humidity);
    }
}
