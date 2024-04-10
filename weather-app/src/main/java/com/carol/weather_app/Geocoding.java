package com.carol.weather_app;

public class Geocoding {
    private final double lat;
    private final double lon;
	
	public Geocoding(double lat, double lon) {
	    this.lat = lat;
	    this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

}
