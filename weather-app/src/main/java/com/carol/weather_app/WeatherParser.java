package com.carol.weather_app;
import org.json.JSONObject;
import org.json.JSONArray;

public class WeatherParser {
	public Weather JSONDataParser(String json) {
	    //String jsonData = "{\"coord\":{\"lon\":121.5319,\"lat\":25.0478},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"base\":\"stations\",\"main\":{\"temp\":21.99,\"feels_like\":21.84,\"temp_min\":19.07,\"temp_max\":23.93,\"pressure\":1012,\"humidity\":61},\"visibility\":10000,\"wind\":{\"speed\":1.79,\"deg\":140,\"gust\":3.13},\"clouds\":{\"all\":75},\"dt\":1712780451,\"sys\":{\"type\":2,\"id\":266033,\"country\":\"TW\",\"sunrise\":1712784914,\"sunset\":1712830449},\"timezone\":28800,\"id\":1668341,\"name\":\"Taipei\",\"cod\":200}";
        JSONObject jsonObj = new JSONObject(json);

        // Get the current weather object
        JSONObject currentWeather = jsonObj.getJSONObject("current");

        // Get the temperature. Note that the temperature value is in Kelvin.
        double tempK = currentWeather.getDouble("temp");
        // Convert temperature to degrees Celsius
        double tempC = tempK - 273.15;

        // Get the first element of the weather array
        JSONArray weatherArray = currentWeather.getJSONArray("weather");
        JSONObject weather = weatherArray.getJSONObject(0);
        
        // Get key weather conditions and detailed descriptions
        String main = weather.getString("main");
        String description = weather.getString("description");
	    
        Weather weatherInfo = new Weather(main, description, tempC);
	    
	    return weatherInfo;
	}

}
