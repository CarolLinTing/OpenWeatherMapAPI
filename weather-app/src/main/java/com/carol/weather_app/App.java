package com.carol.weather_app;
import java.util.Scanner;

/**
 * Simple java maven API program for testing
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a city name:");
        String city = scanner.nextLine();

        WeatherService weatherService = new WeatherService();
        String weather = weatherService.getWeather(city);
        System.out.println("Current weather in " + city + ": ");
        System.out.println(weather);
    }
}