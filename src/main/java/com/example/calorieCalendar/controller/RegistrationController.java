package com.example.calorieCalendar.controller;

import com.example.calorieCalendar.dto.RegistrationForm;
import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/register")
public class RegistrationController extends ContextController{
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;
    public RegistrationController(
            UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }
    @GetMapping
    public String registerForm(Model model) {
        model.addAttribute(new RegistrationForm());
        return "registration";
    }
    @PostMapping
    public String processRegistration(@Valid RegistrationForm form, Model model) {
        Optional<User> newUser = userRepo.findByLogin(form.getLogin());
        if(newUser.isPresent()){
            model.addAttribute("error", "Пользователь с данныи логином уже существует!");
            return "registration";
        }
        if(!form.getPassword().equals(form.getRepeatPassword())){
            model.addAttribute("error", "Пароль не совпадает");
            return "registration";
        }
        else{
            User user = new User(form.getLogin(), passwordEncoder.encode(form.getPassword()));
            userRepo.save(user);
            return "redirect:/login";
        }
    }
}
