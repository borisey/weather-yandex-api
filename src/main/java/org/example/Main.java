package org.example;

public class Main {
    public static void main(String[] args) {
        int limit = 5;

        Weather weather = new Weather();
        String weatherJson = weather.getWeather(limit);

        System.out.println("All data: " + weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println("Current temperature: " + root.getFact().getTemp());
    }
}