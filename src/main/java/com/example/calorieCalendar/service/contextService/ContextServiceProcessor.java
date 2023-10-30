package com.example.calorieCalendar.service.contextService;

import com.example.calorieCalendar.model.User;
import org.springframework.ui.Model;

public interface ContextServiceProcessor {
    void addDataToModel(Model model, User user);


}
