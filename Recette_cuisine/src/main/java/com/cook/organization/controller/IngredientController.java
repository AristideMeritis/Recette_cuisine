package com.cook.organization.controller;

import com.cook.organization.entity.Ingredient;
import com.cook.organization.service.IngredientRecord;
import com.cook.organization.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;
    private List<Ingredient> ingredientList = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> addIngredient(@RequestBody IngredientRecord ingredientRec) {
        String response = ingredientService.addIngredient(ingredientRec);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/getAll")
    public Iterable<Ingredient> getAllIngredient() {
        return ingredientService.getIngredients();
    }

}


