package org.example;

public class Main {
    public static void main(String[] args) {
        Weather weather = new Weather();
        String weatherJson = weather.getWeather();

        System.out.println(weatherJson);

//            JsonReader reader = Json.createReader(new StringReader(jsonString));
//
//            JsonStructure jsonStructure = reader.read();
//
//            if (jsonStructure.getValueType() == JsonValue.ValueType.OBJECT) {
//                JsonObject jsonObject = (JsonObject) jsonStructure;
//                int fact = jsonObject.getInt("now");
//                System.out.println("Temperature: " + fact);
//            }

    }
}