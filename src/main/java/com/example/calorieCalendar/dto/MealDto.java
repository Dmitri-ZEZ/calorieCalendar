package com.example.calorieCalendar.dto;

import com.example.calorieCalendar.model.MealType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class MealDto {
    private Long id;
    private Long productId;
    @NotNull(message = "Пожалуйста введите колличество грамм")
    @Min(value = 1, message = "Колличество грамм не может быть меньше одного")
    @Max(value = 1000, message = "Колличество грамм не может быть больше тысячи")
    private Integer gramms;
    private MealType mealType;
}
