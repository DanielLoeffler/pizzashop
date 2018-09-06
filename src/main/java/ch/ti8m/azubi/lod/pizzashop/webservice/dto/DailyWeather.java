package ch.ti8m.azubi.lod.pizzashop.webservice.dto;

import ch.ti8m.azubi.lod.pizzashop.webservice.dto.type.WeatherCondition;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

/**
 * Daily weather data DTO
 */
public class DailyWeather {

    @JsonProperty("date")
    private LocalDate date;

    @JsonProperty("temperature")
    private double temperatureCelsius;

    @JsonProperty("condition")
    private WeatherCondition weatherCondition;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperatureCelsius() {
        return temperatureCelsius;
    }

    public void setTemperatureCelsius(double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public WeatherCondition getWeatherCondition() {
        return weatherCondition;
    }

    public void setWeatherCondition(WeatherCondition weatherCondition) {
        this.weatherCondition = weatherCondition;
    }
}
