package com.example.calorieCalendar.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "calories.calendar")
public class ConfigurationParametrs {
    private String appName = "app";

}
