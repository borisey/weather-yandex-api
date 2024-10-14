package org.example;

public class Main {
    public static void main(String[] args) {
        Weather weather = new Weather();
        String weatherJson = weather.getWeather();

        System.out.println("All data: " + weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println("Temperature: " + root.getFact().getTemp());
    }
}