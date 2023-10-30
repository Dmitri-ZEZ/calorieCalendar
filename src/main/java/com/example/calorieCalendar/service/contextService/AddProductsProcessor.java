package com.example.calorieCalendar.service.contextService;

import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.Collections;

@Component
public class AddProductsProcessor implements ContextServiceProcessor{
    private final ProductRepository productRepository;

    public AddProductsProcessor(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void addDataToModel(Model model, User user) {
        model.addAllAttributes(Collections.singleton(productRepository.findAll()));
    }
}
