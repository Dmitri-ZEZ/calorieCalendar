package com.example.calorieCalendar.controller;

import com.example.calorieCalendar.bean.ConfigurationParametrs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController extends ContextController {

    @Autowired
    private ConfigurationParametrs configurationParametrs;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("appName", configurationParametrs.getAppName());
        return "home";
    }


    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }
}
