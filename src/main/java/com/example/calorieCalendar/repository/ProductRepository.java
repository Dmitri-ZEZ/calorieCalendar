package com.example.calorieCalendar.repository;

import com.example.calorieCalendar.model.Meal;
import com.example.calorieCalendar.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
