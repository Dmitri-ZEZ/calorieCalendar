package com.example.calorieCalendar.service.contextService;

import com.example.calorieCalendar.model.Meal;
import com.example.calorieCalendar.model.MealType;
import com.example.calorieCalendar.model.ProductAndGramms;
import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.repository.MealRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.stream.StreamSupport;

@Component
public class AddSumCaloriesForMealProcessor implements ContextServiceProcessor{
    private final MealRepository mealRepository;

    public AddSumCaloriesForMealProcessor(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public void addDataToModel(Model model, User user) {
        Integer allCalories = 0;

        Integer breakfastCalories = calculateForMeals(MealType.BREAKFAST, user);
        model.addAttribute("breakfastCalories", breakfastCalories);
        allCalories+=breakfastCalories;

        Integer dinnerCalories = calculateForMeals(MealType.DINNER, user);
        model.addAttribute("dinnerCalories", dinnerCalories);
        allCalories+=dinnerCalories;

        Integer supperCalories = calculateForMeals(MealType.SUPPER, user);
        model.addAttribute("supperCalories", supperCalories);
        allCalories+=supperCalories;

        model.addAttribute("allCalories", allCalories);
    }

    private Integer calculateForMeals(MealType mealType, User user){
        Iterable<Meal> allMeal = mealRepository.findMealByUser(user);
        return StreamSupport.stream(allMeal.spliterator(), false)
                .filter(meal -> meal.getMealType().equals(mealType))
                .flatMap(meal -> meal.getProductAndGrammsList().stream())
                .map(ProductAndGramms::getCalories)
                .reduce(0, Integer::sum);
    }
}
