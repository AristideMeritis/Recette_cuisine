package com.cook.organization.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "commentaire")
public class Commentaire {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "commentaire", length = 255, nullable = true)
    private String commentaire;
    @Column(name = "auteur", length = 40, nullable = false)
    private String auteur;

    @Column(name = "date", nullable = false)
    private LocalDate dateAjout;



    public LocalDate getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(LocalDate dateAjout) {
        this.dateAjout = dateAjout;
    }


    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public Long getId() {
        return id;
    }

}
