package com.carol.weather_app;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class WeatherService {
    private final String apiKey = "c587c657c720e5731e8b7c27eab930cb";

    public String getWeather(String city) {
        HttpClient client = HttpClient.newHttpClient();
        double lat = 0;
        double lon = 0;
        
        //Geocoding API from https://openweathermap.org/api/geocoding-api
        String geoURL = "http://api.openweathermap.org/geo/1.0/direct?q="+ city +
        		"&limit=1&appid="+ apiKey;
        HttpRequest requestGeo = HttpRequest.newBuilder()
                .uri(URI.create(geoURL))
                .build();
        try {
            HttpResponse<String> responseGeo = client.send(requestGeo, HttpResponse.BodyHandlers.ofString());
            
            //Latitude, Longitude of city
            lat = new GeoParser().JSONGeoParser(responseGeo.body()).getLat();
            lon = new GeoParser().JSONGeoParser(responseGeo.body()).getLon();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Unable to retrieve geo data");
        }
        
        /* https://openweathermap.org/api/one-call-3
         * https://api.openweathermap.org/data/3.0/onecall?lat={lat}&lon={lon}&exclude={part}&appid={API key}
         */
        String endpoint = "https://api.openweathermap.org/data/3.0/onecall?lat="+ lat +
        		"&lon="+ lon + "&appid=" + apiKey;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            Weather weatherInfo = new WeatherParser().JSONDataParser(response.body());
            
            return weatherInfo.toString();
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Unable to retrieve weather data";
        }
        
    }
}
