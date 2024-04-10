package com.carol.weather_app;
import org.json.JSONObject;
import org.json.JSONArray;

public class GeoParser {
	public Geocoding JSONGeoParser(String json) {
        // Convert string to JSON array
        JSONArray jsonArray = new JSONArray(json);

        // the first element of the array
        JSONObject firstItem = jsonArray.getJSONObject(0);

        // get lat,lon
        double lat = firstItem.getDouble("lat");
        double lon = firstItem.getDouble("lon");

        Geocoding GeoInfo = new Geocoding(lat, lon);
        
        return GeoInfo;
        
	}
}
