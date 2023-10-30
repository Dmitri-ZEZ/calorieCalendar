package com.example.calorieCalendar.service.contextService;

import com.example.calorieCalendar.dto.MealDto;
import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.repository.MealRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Collections;

@Component
public class AddMealsProcessor implements ContextServiceProcessor {
    private final MealRepository mealRepository;

    public AddMealsProcessor(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public void addDataToModel(Model model, User user) {
        model.addAttribute(new MealDto());
        if (user != null) {
            model.addAllAttributes(Collections.singleton(mealRepository.findMealByUser(user)));
        }
    }
}
