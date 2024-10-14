package org.weather.models;

public class Parts {
    private Day day;

    public Parts(String date, Parts parts, Day day)
    {
        this.day = day;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
