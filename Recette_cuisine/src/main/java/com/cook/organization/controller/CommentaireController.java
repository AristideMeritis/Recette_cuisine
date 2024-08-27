package com.cook.organization.controller;

import com.cook.organization.entity.Commentaire;
import com.cook.organization.entity.CommentaireRecord;
import com.cook.organization.exception.NoSuchCommentaireExcption;
import com.cook.organization.exception.RecetteNotFoundException;
import com.cook.organization.service.CommentaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commentaire")
public class CommentaireController {

    @Autowired
    private CommentaireService commentaireService;

    @GetMapping("/getallCommentaire")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(commentaireService.getCommentaires());

    }

    @GetMapping("auteur/{auteur}")
    public ResponseEntity<?> findByAuteur(@PathVariable("auteur") String auteur) {
        try {
            List<Commentaire> commentaires = commentaireService.findCommentaireByAuteur(auteur);
            return ResponseEntity.ok(commentaires);
        } catch (IllegalArgumentException e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            Commentaire commentairefound = commentaireService.findByID(id);
            return ResponseEntity.ok(commentairefound);
        } catch (IllegalStateException | NoSuchCommentaireExcption e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PostMapping(path="/{rectteId}/addCommentaire", consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody CommentaireRecord commentaireRec, @PathVariable("recetteId") Long rectteId) {
        try {
            Commentaire commentaire = new Commentaire();
            commentaire.setAuteur(commentaireRec.auteur());
            commentaire.setCommentaire(commentaireRec.commentaire());
            commentaire.setDateAjout(commentaireRec.date());
             return ResponseEntity.ok(commentaireService.addCommentaire(commentaire, rectteId));
        }catch (Exception e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCommentaireById(@PathVariable Long id) {

        try{
            Commentaire  commentaire = commentaireService.deleteCommentaireById(id);
            return ResponseEntity.ok(commentaire);

        }catch ( NoSuchCommentaireExcption e)
        {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @PutMapping("/commentaire/putCommentaire/{id}")
    public Commentaire updateCommentaire(@RequestBody Commentaire commentaire
            , @PathVariable Long id) {
        return commentaireService.updateCommentaireById(commentaire, id);
    }
}
