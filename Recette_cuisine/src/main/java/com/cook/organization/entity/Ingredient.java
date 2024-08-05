package com.cook.organization.entity;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;

    private String nom;
    private int quantite;

    public Ingredient() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ingredient(String nom, int quantite)
    {
        this.nom =  nom;
        this.quantite = quantite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getID(){
        return this.id.toString();
    }


}
