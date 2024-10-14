package org.example.models;

import java.util.List;

public class Root {
    private Fact fact;
    private List<Forecasts> forecasts;

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
