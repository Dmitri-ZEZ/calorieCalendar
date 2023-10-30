package com.example.calorieCalendar.repository;

import com.example.calorieCalendar.model.Product;
import com.example.calorieCalendar.model.ProductAndGramms;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAndGrammsRepository extends CrudRepository<ProductAndGramms, Long> {
}
