package org.example;

import org.example.model.Forecasts;
import org.example.model.Parts;
import org.example.model.Root;

import java.util.List;

public class Main {
    static final int DAYS_LIMIT = 5;

    public static void main(String[] args) {
        GsonParser parser = new GsonParser();
        Root root = parser.parse(getAllData());

        System.out.println("All data: " + getAllData());
        System.out.println("Current temperature: " + getCurrentTemperature(root));
        System.out.println("Average temperature for next " + DAYS_LIMIT + " days: " + getAverageTemperature(root));
    }

    private static String getAllData() {
        WeatherRequest weatherRequest = new WeatherRequest();

        return weatherRequest.getWeather(DAYS_LIMIT);
    }

    private static int getCurrentTemperature(Root root) {
        return root.getFact().getTemp();
    }

    private static float getAverageTemperature(Root root) {
        List<Forecasts> forecasts = root.getForecasts();
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