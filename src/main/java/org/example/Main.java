package org.example;

import org.example.model.Root;

public class Main {
    public static void main(String[] args) {
        int weeksLimit = 1;

        WeatherRequest weatherRequest = new WeatherRequest();
        String weatherJson = weatherRequest.getWeather(weeksLimit);

        System.out.println("All data: " + weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println("Current temperature: " + root.getFact().getTemp());

        System.out.println("Average temperature for " + weeksLimit + " weeks: ");
    }
}