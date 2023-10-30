package com.example.calorieCalendar.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ProductAndGramms {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer gramms;
    private Integer calories = 1;
    @ManyToOne
    private Product product;

    public void calculateCalories() {
        calories += ((product.getCalories() * gramms) / 100);
    }
}
