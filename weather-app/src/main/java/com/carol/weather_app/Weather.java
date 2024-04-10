package com.carol.weather_app;

public class Weather {
    private String main;
	private String description;
    private double temperature;
    
    public Weather() {
	}
    
    public Weather(String main, String description, double temperature) {
		super();
		this.main = main;
		this.description = description;
		this.temperature = temperature;
	}
    
    public String getMain() {
		return main;
	}
	public void setMain(String main) {
		this.main = main;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		return "Main status is "+main+", with a detailed description of "+ description +
				", and the temperature is " + temperature +" degrees.";
	}
}

