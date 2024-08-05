package com.cook.organization.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name="Recette")
public class Recette {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "recette_id", nullable = false)
    private Long id;
    @Column(name="titre", length = 255, nullable = false, unique = false)
    private String titre;
    @Column(name="description", length = 255, nullable = false, unique = false)
    private String description;
    @Column(name="instructions", length = 500, nullable = false, unique = false)
    private  List<String> instructions;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "categorie_id", referencedColumnName = "categorie_id")
    private Categorie categorie;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "recette_id")
    private List<Ingredient> ingredients;
    @Column(name="auteur", length = 50, nullable = false, unique = false)
    private String auteur;

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

}
