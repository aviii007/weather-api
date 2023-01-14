package com.weather.api.Model;

public class WeatherForecast {

    private String location;
    private String date;
    private String temperature;
    private String precipitation;
    private String snow;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(String precipitation) {
        this.precipitation = precipitation;
    }

    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public WeatherForecast(String location, String date, String temperature, String precipitation, String snow) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.snow = snow;
    }
}
