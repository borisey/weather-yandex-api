package org.example;

import org.example.model.Forecasts;
import org.example.model.Root;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int weeksLimit = 5;

        WeatherRequest weatherRequest = new WeatherRequest();
        String weatherJson = weatherRequest.getWeather(weeksLimit);

        System.out.println("All data: " + weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println("Current temperature: " + root.getFact().getTemp());


        List<Forecasts> forecasts = root.getForecasts();

        for (var i = 0; i < forecasts.size(); i++) {
            Forecasts forecast = forecasts.get(i);

            System.out.println(forecast.getDate());
        }

//        System.out.println("Average temperature for " + weeksLimit + " weeks: " + root.getForecasts());
    }
}