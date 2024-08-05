package com.cook.organization.controller;

import com.cook.organization.entity.Recette;
import com.cook.organization.exception.RecetteIdMismatchException;
import com.cook.organization.exception.RecetteNotFoundException;
import com.cook.organization.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class RecetteController {

    @Autowired
    private RecetteRepository recetteRepository;

    @GetMapping
    public Iterable findAll() {
        return recetteRepository.findAll();
    }

    @GetMapping("/titre/{rectteTitre}")
    public List findByTitre(@PathVariable String recetteTitre) {
        return recetteRepository.findByTitre(recetteTitre);
    }

    @GetMapping("/{id}")
    public Recette findOne(@PathVariable Long id) {
        return recetteRepository.findById(id)
                .orElseThrow(RecetteNotFoundException::new);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Recette create(@RequestBody Recette recette) {
        return recetteRepository.save(recette);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        recetteRepository.findById(id)
                .orElseThrow(RecetteNotFoundException::new);
        recetteRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Recette updateBook(@RequestBody Recette recette, @PathVariable Long id) {
        if (recette.getId() != id) {
            try {
                throw new RecetteIdMismatchException();
            } catch (RecetteIdMismatchException e) {
                throw new RuntimeException(e);
            }
        }
        recetteRepository.findById(id)
                .orElseThrow(RecetteNotFoundException::new);
        return recetteRepository.save(recette);
    }
}
