package com.example.calorieCalendar.controller;

import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.service.contextService.ContextServiceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service
public abstract class ContextController {

    private List<ContextServiceProcessor> contextServiceProcessorList;

    @Autowired
    public void setContextServiceProcessorList(List<ContextServiceProcessor> contextServiceProcessorList) {
        this.contextServiceProcessorList = contextServiceProcessorList;
    }

    @ModelAttribute
    protected void addDataToModel(Model model, @AuthenticationPrincipal User user) {
        contextServiceProcessorList
                .forEach(contextServiceProcessor -> contextServiceProcessor.addDataToModel(model, user));
    }
}