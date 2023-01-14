package com.weather.api.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.weather.api.Model.WeatherForecast;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Value("${weather.api.key}")
    private String apiKey;

    @GetMapping("/forecast/{location}")
    public WeatherForecast forecast(@PathVariable String location) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", "3fe421aa57mshdfd4147f4d4c319p1ba7f4jsnca7d59efce2d");
        headers.set("X-RapidAPI-Host", "visual-crossing-weather.p.rapidapi.com");
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(
                "https://visual-crossing-weather.p.rapidapi.com/forecast?aggregateHours=24&location=Washington%2CDC%2CUSA&contentType=csv&unitGroup=us&shortColumnNames=0",
                HttpMethod.GET, entity, String.class);

        ObjectMapper mapper = new ObjectMapper();
        WeatherForecast forecast = null;
        try {
            forecast = mapper.readValue(response.getBody(), WeatherForecast.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return forecast;
    }

}

