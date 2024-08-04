package com.cook.organization.entity;

import java.util.List;
import java.util.UUID;

public class Recette {
    private UUID id;
    private String titre;
    private String description;
    private  List<String> instructions;
    private Categorie categorie;
    private List<Ingredient> ingredients;
    private String auteur;

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public void creerRecette(String titre, String description, List<String> instructions,
                             Categorie categorie, String auteur)
    {}

    public void modifierRecette(String titre, String description, List<String> instructions,
                             Categorie categorie, String auteur)
    {}

    public void supprimerRecette(String titre, String description, List<String> instructions,
                             Categorie categorie, String auteur)
    {}
}
