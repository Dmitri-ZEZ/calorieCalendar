package com.example.calorieCalendar.repository;

import com.example.calorieCalendar.model.Meal;
import com.example.calorieCalendar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    List<Meal> findMealByUser(User user);
}
