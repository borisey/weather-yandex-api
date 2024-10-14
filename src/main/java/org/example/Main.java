package org.example;

import org.example.models.Root;
import org.example.services.WeatherService;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherService.getAllData());

        System.out.println("All weather data: " + weatherService.getAllData());
        System.out.println("Current temperature: " + weatherService.getCurrentTemperature(root));
        System.out.println("Average temperature for next " + WeatherService.DAYS_LIMIT + " days: " + weatherService.getAverageTemperature(root));
    }
}