package com.cook.organization.entity;

import jakarta.persistence.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    @Column(name = "categorie", nullable = false)
    private Categorie categorie;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ingredient_id")
    private List<Ingredient> ingredients;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "commentaire_id", nullable = false)
    private List<Commentaire> commentaires = new ArrayList<>();
    @Column(name="auteur", length = 50, nullable = false, unique = false)
    private String auteur;

    @Transient
    private URI locationURI;

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


    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }
    public void validate() throws IllegalStateException {
        if (ingredients.size() == 0) {
            throw new IllegalStateException(
                    "You need at least one ingredient for your recipe!");
        } else if (instructions.size() == 0) {
            throw new IllegalStateException(
                    "You need at least one step for your recipe!");
        }
    }

    public void generateLocationURI() {
        try {
            locationURI = new URI(
                    ServletUriComponentsBuilder.fromCurrentContextPath()
                            .path("/recette/")
                            .path(String.valueOf(id))
                            .toUriString());
        } catch (URISyntaxException e) {
            // exception should stop here.
        }
    }

}
