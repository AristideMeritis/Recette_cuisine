package com.cook.organization.service;

import com.cook.organization.entity.Ingredient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientService {

    private List<Ingredient> ingredientList = new ArrayList<>();

    public void addIngredient(){
        Ingredient ingredTomate = new Ingredient("Tomate", 3);
        Ingredient ingredOignons = new Ingredient("Oignons", 6);
        ingredientList.add(ingredTomate);
        ingredientList.add(ingredOignons);
    }

    public List<Ingredient> getIngredients()
    {
        return ingredientList;
    }




}
