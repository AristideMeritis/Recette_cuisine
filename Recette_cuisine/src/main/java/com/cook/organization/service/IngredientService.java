package com.cook.organization.service;

import com.cook.organization.entity.Ingredient;
import com.cook.organization.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService   {
    @Autowired
    private IIngredientRepository ingredientRepository;
    private List<Ingredient> ingredientList = new ArrayList<>();

    public String addIngredient(IngredientRecord ingredientRec){
        Ingredient ingredient = new Ingredient();
        ingredient.setNom(ingredientRec.nom());
        ingredient.setQuantite(ingredient.getQuantite());
        ingredientRepository.save(ingredient);
        return "ADDED";

    }

    public Iterable<Ingredient> getIngredients()
    {
        return  ingredientRepository.findAll();
    }





}
