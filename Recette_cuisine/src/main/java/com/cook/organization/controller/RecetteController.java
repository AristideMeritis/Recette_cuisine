package com.cook.organization.controller;

import com.cook.organization.entity.Categorie;
import com.cook.organization.entity.Ingredient;
import com.cook.organization.entity.Recette;
import com.cook.organization.exception.RecetteIdMismatchException;
import com.cook.organization.exception.RecetteNotFoundException;
import com.cook.organization.repository.RecetteRepository;
import com.cook.organization.service.RecetteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecetteController {

    @Autowired
    private RecetteService recetteService;

    record NewRecetteRequest(
            String titre,
            List<String> instructions,
            String description,
            String auteur,
            Categorie categorie,
            List<Ingredient> ingredients

    ) {
    }

    @GetMapping("/recette/getALL")
    public Iterable findAll() {
        return recetteService.findAll();
    }

    @GetMapping("/recette/titre/{rectteTitre}")
    public List findByTitre(@PathVariable String recetteTitre) {
        return recetteService.findByTitre(recetteTitre);
    }

    @GetMapping("/{id}")
    public Recette findById(@PathVariable Long id) {
        return recetteService.findById(id);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recette create(@RequestBody NewRecetteRequest recetteRequest) {
        Recette recette = new Recette();
        recette.setAuteur(recetteRequest.auteur());
        recette.setDescription(recetteRequest.description());
        recette.setInstructions(recetteRequest.instructions());
        recette.setIngredients(recetteRequest.ingredients());
        return recetteService.save(recette);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recetteService.deleteById(id);
    }

    @PutMapping("/{id}")
    public Recette updateBook(@RequestBody Recette recette, @PathVariable Long id) {
        return recetteService.updateRecetteById(recette, id);
    }
}
