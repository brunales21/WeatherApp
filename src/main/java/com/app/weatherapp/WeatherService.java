package com.app.weatherapp;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.math.BigDecimal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class WeatherService {

    private static final String API_KEY = "c37f27d3b5efe8d856bf0e9fa36fc1ae";  // Reemplaza con tu clave de API
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final OkHttpClient httpClient = new OkHttpClient();


    public WeatherData getWeatherData(String location) throws IOException {
        String requestUrl = API_URL + "?q=" + location + "&appid=" + API_KEY;

        Request request = new Request.Builder()
                .url(requestUrl)
                .build();

        try (Response response = httpClient.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }


            JSONObject json = new JSONObject(response.body());
            JSONArray weather = json.getJSONArray("weather");
            JSONObject valorClima = weather.getJSONObject(0);
            String clima = valorClima.getString("main");

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
            int lluvia = 0;
            if ((valorLLuvia=json.getJSONObject("rain"))!=null) {

                 lluvia = valorLLuvia.getInt("h1");
                System.out.println(lluvia);
            }

            // Como ejemplo, crearemos un objeto WeatherData con valores predeterminados
            WeatherData weatherData = new WeatherData(location,temperatura,temperaturaMinima,temperaturaMaxima
            ,clima,lluvia,wind,humidity);

            return weatherData;
        }
    }

    // Método para parsear la respuesta JSON y construir un objeto WeatherData
    private WeatherData parseJsonResponse(String jsonResponse) {
        // Implementar lógica de parsing aquí
        return null;
    }


}
