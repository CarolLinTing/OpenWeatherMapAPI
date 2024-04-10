package com.carol.weather_app;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public class GeoParser {
	public Geocoding JSONGeoParser(String json) {
	    try {
	        JSONArray jsonArray = new JSONArray(json);
	        JSONObject firstItem = jsonArray.getJSONObject(0);
	        double lat = firstItem.getDouble("lat");
	        double lon = firstItem.getDouble("lon");
	        return new Geocoding(lat, lon);
	    } catch (JSONException e) {
	        // Handle error or return null
	        return null;
	    }
	}

}
