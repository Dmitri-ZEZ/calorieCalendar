package com.example.calorieCalendar.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RegistrationForm {
    private String login;
    private String password;
    private String repeatPassword;
}