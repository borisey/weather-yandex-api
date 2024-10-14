package org.example;

import org.example.model.Root;

public class Main {
    static final int DAYS_LIMIT = 5;

    public static void main(String[] args) {
        WeatherRequest weatherRequest = new WeatherRequest();

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherRequest.getAllData());

        System.out.println("All data: " + weatherRequest.getAllData());
        System.out.println("Current temperature: " + weatherRequest.getCurrentTemperature(root));
        System.out.println("Average temperature for next " + DAYS_LIMIT + " days: " + weatherRequest.getAverageTemperature(root));
    }
}