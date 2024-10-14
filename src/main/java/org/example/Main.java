package org.example;

import org.example.model.Forecasts;
import org.example.model.Parts;
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

        int allTemps = 0;
        float averageTemperature = 0F;

        for (var i = 0; i < forecasts.size(); i++) {
            Forecasts forecast = forecasts.get(i);
            Parts parts = forecast.getParts();

            System.out.println(parts.getDay().getTempAvg());

            allTemps += parts.getDay().getTempAvg();
            averageTemperature = (float) allTemps / weeksLimit;
        }

        System.out.println(allTemps);

        System.out.println(averageTemperature);

//        System.out.println("Average temperature for " + weeksLimit + " weeks: " + root.getForecasts());
    }
}