package org.weather;

import org.weather.models.Root;
import org.weather.parsers.GsonParser;
import org.weather.services.WeatherService;

public class Main {
    public static void main(String[] args) {
        WeatherService weatherService = new WeatherService();
        GsonParser parser             = new GsonParser();
        String allWeatherData         = weatherService.getWeather();
        Root root                     = parser.parse(allWeatherData);

        System.out.println("All weather data: " + allWeatherData);
        System.out.println("Current temperature: " + weatherService.getCurrentTemperature(root));
        System.out.println("Average temperature for next " + WeatherService.DAYS_LIMIT + " days: " + weatherService.getAverageTemperature(root));
    }
}