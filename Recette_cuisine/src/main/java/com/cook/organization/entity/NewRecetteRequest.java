package com.cook.organization.entity;

import java.util.List;


public record NewRecetteRequest(
        String titre,
        List<String> instructions,
        String description,
        String auteur,
        Categorie categorie,
        List<Ingredient> ingredients

) {
}