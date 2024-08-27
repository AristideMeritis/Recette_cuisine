package com.cook.organization.service;

import com.cook.organization.entity.Commentaire;
import com.cook.organization.entity.Recette;
import com.cook.organization.exception.NoSuchCommentaireExcption;
import com.cook.organization.repository.ICommentaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CommentaireService {

    private  final ICommentaireRepository  commentaireRepository;
    private RecetteService recetteService;
    private List<Commentaire> commentaires = new ArrayList<>();
    @Autowired
    public CommentaireService(ICommentaireRepository commentaireRepository, RecetteService recetteService )
    {
        this.commentaireRepository = commentaireRepository;
        this.recetteService = recetteService;
    }

    public String addCommentaire(Commentaire commentaire, Long recetteID)
    {
        Recette recette = recetteService.findById(recetteID);
        recette.getCommentaires().add(commentaire);
        recetteService.updateRecetteById(recette,recette.getId());
        commentaireRepository.save(commentaire);
        return "Added";

    }

    public Iterable<Commentaire> getCommentaires()
    {
        return  commentaireRepository.findAll();
    }

    public List findCommentaireByAuteur(String auteur)
    {
        return (List) commentaireRepository.
                findComByAuteur(auteur).
                orElseThrow(IllegalArgumentException::new);
    }


    public Commentaire findByID(Long id) throws NoSuchCommentaireExcption {
        Optional<Commentaire> commentaireOpt =
                commentaireRepository.findById(id);

        if(commentaireOpt.isEmpty())

                throw new NoSuchCommentaireExcption("Commentaire absent avec cette "+id);

        return commentaireOpt.get();
    }

    public Commentaire deleteCommentaireById(Long id) throws IllegalArgumentException, NoSuchCommentaireExcption {
        Optional<Commentaire> commentaireToDelete = Optional.ofNullable(this.findByID(id));
        if(commentaireToDelete.isEmpty())
            throw  new IllegalArgumentException(
                "l'id passé en paramètre n'existe pas");

        return commentaireToDelete.get();
    }

    public Commentaire updateCommentaireById(Commentaire commentaire, Long id) {

        commentaireRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
        return commentaireRepository.save(commentaire);
    }


}
