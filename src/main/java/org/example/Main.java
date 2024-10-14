package org.example;

import org.example.model.Forecasts;
import org.example.model.Parts;
import org.example.model.Root;

import java.util.List;

public class Main {
    static final int DAYS_LIMIT = 5;

    public static void main(String[] args) {
        WeatherRequest weatherRequest = new WeatherRequest();
        String weatherJson = weatherRequest.getWeather(DAYS_LIMIT);

        System.out.println("All data: " + weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println("Current temperature: " + root.getFact().getTemp());

        List<Forecasts> forecasts = root.getForecasts();

        float averageTemperature = getAverageTemperature(forecasts);

        System.out.println("Average temperature for next " + DAYS_LIMIT + " days: " + averageTemperature);
    }

    private static float getAverageTemperature(List<Forecasts> forecasts) {
        int allTemperatures = 0;
        float averageTemperature = 0F;

        for (Forecasts forecast : forecasts) {
            Parts parts = forecast.getParts();
            allTemperatures += parts.getDay().getTempAvg();
            averageTemperature = (float) allTemperatures / DAYS_LIMIT;
        }

        return averageTemperature;
    }
}