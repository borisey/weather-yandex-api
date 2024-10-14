package org.example.weather;

import com.google.gson.Gson;

public class GsonParser {
    public Root parse(String weatherJson)
    {
        Gson gson = new Gson();

        return gson.fromJson(weatherJson, Root.class);
    }
}
