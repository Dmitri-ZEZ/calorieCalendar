package com.example.calorieCalendar.security;

import com.example.calorieCalendar.model.User;
import com.example.calorieCalendar.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Optional;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .securityMatcher("/", "/login", "/addMeal", "/logout", "/deleteMeal")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasRole("USER")
                )
                .httpBasic(withDefaults())
                .formLogin(form -> form
                        .loginPage("/login")
                        .usernameParameter("login")
                        .passwordParameter("password")
                        .permitAll())
                .logout(logout -> logout
                        .logoutSuccessUrl("/login"))
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return login -> {
            Optional<User> user = userRepo.findByLogin(login);
            if (user.isPresent()) {
                return user.get();
            }
            throw new UsernameNotFoundException("User ‘" + login + "’ not found");
        };
    }
}
