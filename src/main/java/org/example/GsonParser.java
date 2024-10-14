package org.example;

import com.google.gson.Gson;
import org.example.models.Root;

public class GsonParser {
    public Root parse(String weatherJson)
    {
        Gson gson = new Gson();

        return gson.fromJson(weatherJson, Root.class);
    }
}
