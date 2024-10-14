package org.example;

import org.example.model.Forecasts;
import org.example.model.Parts;
import org.example.model.Root;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class WeatherRequest {
    static final Float LAT      = 55.75F;
    static final Float LON      = 37.62F;
    static final int DAYS_LIMIT = 5;
    static final String URL     = "https://api.weather.yandex.ru/v2/forecast?lat=" + LAT + "&lon=" + LON + "&limit=";
    static final String API_KEY = "6c9d00db-7689-4b56-bbf1-026e2c0c12e3";

    public String getWeather(int weeksLimit) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL + weeksLimit))
                .header("X-Yandex-Weather-Key", API_KEY)
                .GET()
                .build();

        HttpResponse<String> response = null;

        try {
            response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return response.body();
    }

    public String getAllData() {
        WeatherRequest weatherRequest = new WeatherRequest();

        return weatherRequest.getWeather(DAYS_LIMIT);
    }

    public int getCurrentTemperature(Root root) {
        return root.getFact().getTemp();
    }

    public float getAverageTemperature(Root root) {
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
