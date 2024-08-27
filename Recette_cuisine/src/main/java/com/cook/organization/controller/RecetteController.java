package com.cook.organization.controller;

import com.cook.organization.entity.Categorie;
import com.cook.organization.entity.Ingredient;
import com.cook.organization.entity.NewRecetteRequest;
import com.cook.organization.entity.Recette;
import com.cook.organization.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecetteController {

    @Autowired
    private RecetteService recetteService;


    @GetMapping("/recette/getallRecette")
    public Iterable findAll() {
        return recetteService.findAll();
    }

    @GetMapping("/recette/titre/{rectteTitre}")
    public List findByTitre(@PathVariable String recetteTitre) {
        return recetteService.findByTitre(recetteTitre);
    }

    @GetMapping("/recette/recette/{id}")
    public Recette findById(@PathVariable Long id) {
        return recetteService.findById(id);

    }

    @PostMapping(path="/recette/addRecette", consumes={MediaType.APPLICATION_JSON_UTF8_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Recette create(@RequestBody NewRecetteRequest recetteRequest) {
        Recette recette = new Recette();
        recette.setAuteur(recetteRequest.auteur());
        recette.setDescription(recetteRequest.description());
        recette.setInstructions(recetteRequest.instructions());
        recette.setIngredients(recetteRequest.ingredients());
        recette.setCategorie(recetteRequest.categorie());
        recette.setTitre(recetteRequest.titre());
        return recetteService.save(recette);
    }

    @DeleteMapping("/recette/deleteRecette/{id}")
    public void delete(@PathVariable Long id) {
        recetteService.deleteById(id);
    }

    @PutMapping("/recette/putRecette/{id}")
    public Recette updateBook(@RequestBody Recette recette, @PathVariable Long id) {
        return recetteService.updateRecetteById(recette, id);
    }
}
