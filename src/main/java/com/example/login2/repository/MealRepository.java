package com.example.login2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.login2.entity.AppUser;
import com.example.login2.entity.Meal;

public interface MealRepository extends JpaRepository<Meal, Long> {
    List<Meal> findByUser(AppUser user);
}
