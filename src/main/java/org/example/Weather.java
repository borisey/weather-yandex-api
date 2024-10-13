package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Weather {
    static final Float LAT      = 55.75F;
    static final Float LON      = 37.62F;
    static final String URL     = "https://api.weather.yandex.ru/v2/forecast?lat=" + LAT + "&lon=" + LON;
    static final String API_KEY = "6c9d00db-7689-4b56-bbf1-026e2c0c12e3";

    public String getWeather() {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
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
}
