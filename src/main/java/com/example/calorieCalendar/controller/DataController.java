package com.example.calorieCalendar.controller;

import com.example.calorieCalendar.dto.MealDto;
import com.example.calorieCalendar.model.Meal;
import com.example.calorieCalendar.model.ProductAndGramms;
import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.repository.MealRepository;
import com.example.calorieCalendar.repository.ProductRepository;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping()
public class DataController extends ContextController {

    private final MealRepository mealRepository;
    private final ProductRepository productRepository;

    public DataController(MealRepository mealRepository,
                          ProductRepository productRepository) {
        this.mealRepository = mealRepository;
        this.productRepository = productRepository;
    }


    @PostMapping("/addMeal")
    public String addMeal(@Valid MealDto mealDto, Errors error, @AuthenticationPrincipal User user) {
        if (error.hasErrors()) {
            return "home";
        }

        Meal meal = new Meal();
        meal.setUser(user);
        meal.setMealType(mealDto.getMealType());

        ProductAndGramms productAndGramms = new ProductAndGramms();
        productAndGramms.setProduct(productRepository.findById(mealDto.getProductId()).orElse(null));
        productAndGramms.setGramms(mealDto.getGramms());
        productAndGramms.calculateCalories();
        meal.getProductAndGrammsList().add(productAndGramms);

        mealRepository.save(meal);
        return "redirect:/";
    }

    @PostMapping("/deleteMeal")
    public String deleteMeal(MealDto mealDto) {
        mealRepository.deleteById(mealDto.getId());
        return "redirect:/";
    }
}