package org.weather.models;

public class Forecasts {
    private String date;
    private Parts parts;

    public Forecasts(String date, Parts parts) {
        this.date = date;
        this.parts = parts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Parts getParts() {
        return parts;
    }

    public void setParts(Parts parts) {
        this.parts = parts;
    }
}
