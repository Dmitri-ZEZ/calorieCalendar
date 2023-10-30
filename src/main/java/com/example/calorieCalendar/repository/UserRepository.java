package com.example.calorieCalendar.repository;

import com.example.calorieCalendar.model.Product;
import com.example.calorieCalendar.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLogin(String login);
}
