package com.cook.organization.entity;

import jakarta.persistence.*;

import java.util.UUID;
@Entity
@Table(name = "ingredient")
public class Ingredient
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;

    @Column(name = "nom", length = 40, nullable = false)
    private String nom;
    @Column(name = "quantite", length =40, nullable = false )
    private int quantite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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



}
