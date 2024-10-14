package org.example;

public class Main {
    public static void main(String[] args) {
        Weather weather = new Weather();
        String weatherJson = weather.getWeather();

        System.out.println(weatherJson);

        GsonParser parser = new GsonParser();
        Root root = parser.parse(weatherJson);

        System.out.println(root.getFact().getTemp());
    }
}