package org.example;

import org.example.weather.GsonParser;
import org.example.weather.Root;
import org.example.weather.WeatherRequest;

public class Main {
    public static void main(String[] args) {
        int limit = 5;

        WeatherRequest weatherRequest = new WeatherRequest();
        String weatherJson = weatherRequest.getWeather(limit);

        System.out.println("All data: " + weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println("Current temperature: " + root.getFact().getTemp());
    }
}