package com.cook.organization.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ingredient_id", nullable = false)
    private Long id;

    @Column(name = "name", length = 40, nullable = false)
    private String name;
    @Column(name = "quantite", length = 40, nullable = false)
    private int quantite;

    @ManyToOne()

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }


}
