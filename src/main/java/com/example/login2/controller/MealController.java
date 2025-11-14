package com.example.login2.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.login2.entity.AppUser;
import com.example.login2.entity.Meal;
import com.example.login2.repository.MealRepository;
import com.example.login2.service.UserService;

@Controller
@RequestMapping("/meal")
public class MealController {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserService userService;

    // 食事登録フォーム表示
    @GetMapping("/new")
    public String mealForm() {
        return "meal_form";
    }

    // 食事データ登録
    @PostMapping("/create")
    public String createMeal(@RequestParam String mealType,
                             @RequestParam int calories,
                             @RequestParam String memo,
                             @AuthenticationPrincipal org.springframework.security.core.userdetails.User loginUser) {

        // ログイン中のユーザー取得
        AppUser user = userService.findByUsername(loginUser.getUsername());

        Meal meal = new Meal();
        meal.setMealType(mealType);
        meal.setCalories(calories);
        meal.setMemo(memo);
        meal.setDate(LocalDate.now());
        meal.setUser(user);

        mealRepository.save(meal);

        return "redirect:/meal/list";
    }

    // 一覧画面
    @GetMapping("/list")
    public String mealList(Model model,
                           @AuthenticationPrincipal org.springframework.security.core.userdetails.User loginUser) {

        AppUser user = userService.findByUsername(loginUser.getUsername());
        model.addAttribute("meals", mealRepository.findByUser(user));

        return "meal_list";
    }
}
