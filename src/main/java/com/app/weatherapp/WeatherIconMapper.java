package com.app.weatherapp;

import java.util.HashMap;
import java.util.Map;

public class WeatherIconMapper {
    private static final Map<String, String> iconMap = new HashMap<>();
    static {
        iconMap.put("Rain", "rainy.png");
        iconMap.put("Drizzle", "rainy.png");
        iconMap.put("Clear", "sun.png");
        iconMap.put("Clouds", "cloudy.png");
        iconMap.put("Thunderstorm", "heavy-rain.png");
        iconMap.put("Snow", "snow.png");
        iconMap.put("Mist", "mist.png");
        iconMap.put("Smoke", "smoke.png");
        iconMap.put("Haze", "haze.png");
        iconMap.put("Dust", "dust.png");
        iconMap.put("Fog", "fog.png");
        iconMap.put("Sand", "sand.png");
        iconMap.put("Ash", "ash.png");
        iconMap.put("Squall", "squall.png");
        iconMap.put("Tornado", "tornado.png");
    }
    public static String getWeatherIcon(String clime) {
        return iconMap.getOrDefault(clime, "unknown.png");
    }
}
