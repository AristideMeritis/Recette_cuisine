package com.cook.organization.service;

import com.cook.organization.entity.Ingredient;
import com.cook.organization.entity.IngredientRecord;
import com.cook.organization.repository.IIngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IngredientService   {

    private  final IIngredientRepository ingredientRepository;
    private List<Ingredient> ingredientList = new ArrayList<>();
    @Autowired
    public IngredientService(IIngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public String addIngredient(IngredientRecord ingredientRec){
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientRec.nom());
        ingredient.setQuantite(ingredient.getQuantite());
        ingredientRepository.save(ingredient);
        return "ADDED";

    }

    public Iterable<Ingredient> getIngredients()
    {
        return  ingredientRepository.findAll();
    }

    public List<Ingredient> findIngredientByName(String ingredName)
    {
        Optional<Ingredient> ingredientOptional = ingredientRepository
                                              .findIngredientByName(ingredName);

        if(ingredientOptional.isEmpty())
        {
            throw new IllegalStateException("nom de l'ingredient absent");
        }


        return ingredientOptional.stream().collect(Collectors.toList());
    }


    public Optional<Ingredient> findByID(Long id)
    {
        return ingredientRepository.findById(id);
    }

    public String deleteById (Long id) throws IllegalArgumentException
    {
        Optional<Ingredient> ingredientToDelete = this.findByID(id);
        if(ingredientToDelete.isEmpty()) throw  new IllegalArgumentException(
                "Id passed in parameter doesn't exit"
        );
        ingredientRepository.deleteById(id);
        return "Deleted";
    }





}
