package com.cook.organization.entity;

import java.util.UUID;

public class Commentaire {


    public Commentaire(String texte, String auteur)
    {
            this.id = UUID.randomUUID();
            this.texte = texte;
            this.auteur = auteur;
    }
    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getId() {
        return id.toString();
    }

    private UUID id;
    private String texte;
    private String auteur;

}
