package com.cook.organization.repository;

import com.cook.organization.entity.Commentaire;
import com.cook.organization.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ICommentaireRepository extends JpaRepository<Commentaire,Long > {

    @Query("SELECT com FROM Commentaire com where com.auteur = ?1")
    Optional<Commentaire> findComByAuteur(String name);

}
