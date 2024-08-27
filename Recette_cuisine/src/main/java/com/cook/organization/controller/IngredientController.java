package com.cook.organization.controller;

import com.cook.organization.entity.Ingredient;
import com.cook.organization.entity.IngredientRecord;
import com.cook.organization.service.IngredientService;
import org.hibernate.NonUniqueResultException;
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

    @GetMapping("/getall")
    public Iterable<Ingredient> getAllIngredient() {
        return ingredientService.getIngredients();
    }

    @GetMapping("/getingredientByName/{name}")
    public List<Ingredient> getIngredientByName(@PathVariable String name) {
        if(ingredientService.findIngredientByName(name).stream().count()>1)
        {
            throw  new NonUniqueResultException((int)ingredientService.
                findIngredientByName(name).
                stream().count());
        }
        return ingredientService.findIngredientByName(name);
    }


    @GetMapping("/getIngredientById/{id}")
    public Ingredient findIngredientById(@PathVariable Long id)
    {
        return ingredientService
                .findByID(id)
                .get();
    }

    @DeleteMapping("/deleteIngredientById/{id}")
    public String deleteIngredientById(Long id)
    {
        return ingredientService.deleteById(id);
    }

}






