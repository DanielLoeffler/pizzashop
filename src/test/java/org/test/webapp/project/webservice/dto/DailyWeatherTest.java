package org.test.webapp.project.webservice.dto;

import org.junit.Assert;
import org.junit.Test;
import org.test.webapp.project.util.JsonUtil;
import org.test.webapp.project.webservice.dto.type.WeatherCondition;

import java.time.LocalDate;

/**
 * Tests for the DailyWeather DTO.
 *
 * @author wap
 * @since 27.06.2018
 */
public class DailyWeatherTest {

    @Test
    public void testSerialized() {

        DailyWeather dailyWeather = new DailyWeather();
        dailyWeather.setDate(LocalDate.now());
        dailyWeather.setTemperatureCelsius(22.5);
        dailyWeather.setWeatherCondition(WeatherCondition.PARTIALLY_CLOUDY);

        String json = JsonUtil.stringify(dailyWeather);
        System.out.println(json);

        DailyWeather parser = JsonUtil.parse(DailyWeather.class, json);
        verifyParsed(dailyWeather, parser);
    }

    private void verifyParsed(DailyWeather original, DailyWeather parsed) {
        Assert.assertEquals(original.getDate(), parsed.getDate());
        Assert.assertEquals(original.getTemperatureCelsius(), parsed.getTemperatureCelsius(), 0.00000001);
        Assert.assertEquals(original.getWeatherCondition(), parsed.getWeatherCondition());
    }
}
