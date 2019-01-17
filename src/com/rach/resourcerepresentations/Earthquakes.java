package com.rach.resourcerepresentations;

import java.util.List;

public class Earthquakes {

    private List<Earthquake> earthquakes = null;

    public List<Earthquake> getEarthquakes() {
        return earthquakes;
    }

    public void setEarthquakes(List<Earthquake> earthquakes) {
        this.earthquakes = earthquakes;
    }

    @Override
    public String toString() {
        return "{\"Earthquakes\":{"
                + "\"earthquakes\":" + earthquakes
                + "}}";
    }
}
