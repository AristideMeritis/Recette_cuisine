package com.cook.organization.controller;

import com.cook.organization.entity.Ingredient;
import com.cook.organization.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;

    @PostMapping("/add")
    public void addTweet() {
        ingredientService.addIngredient();
    }

    @GetMapping("/getAll")
    public List<Ingredient> getAllIngredient() {
        return ingredientService.getIngredients();
    }

}


