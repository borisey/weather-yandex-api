package org.example.weather;

import java.util.List;

public class Root {
    private int now;
    private Fact fact;
    private List<Forecasts> forecasts;

    public int getNow()
    {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public Fact getFact()
    {
        return fact;
    }

    public void setFact(Fact fact) {
        this.fact = fact;
    }

    public List<Forecasts> getForecasts()
    {
        return forecasts;
    }

    public void setForecasts(List<Forecasts> forecasts) {
        this.forecasts = forecasts;
    }
}
