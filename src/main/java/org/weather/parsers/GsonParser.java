package org.weather.parsers;

import com.google.gson.Gson;
import org.weather.models.Root;

public class GsonParser {
    public Root parse(String weatherJson)
    {
        Gson gson = new Gson();

        return gson.fromJson(weatherJson, Root.class);
    }
}
