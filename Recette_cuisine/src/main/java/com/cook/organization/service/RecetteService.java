package com.cook.organization.service;

import com.cook.organization.entity.Categorie;
import com.cook.organization.entity.Ingredient;
import com.cook.organization.entity.Recette;
import com.cook.organization.exception.RecetteIdMismatchException;
import com.cook.organization.exception.RecetteNotFoundException;
import com.cook.organization.repository.RecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class RecetteService {

    @Autowired
    private RecetteRepository recetteRepository;


    public Iterable findAll() {
        return recetteRepository.findAll();
    }

    public List findByTitre(String recetteTitre) {
        return recetteRepository.findByTitre(recetteTitre);
    }

    public Recette findById(Long id) {
        return recetteRepository.findById(id)
                .orElseThrow(RecetteNotFoundException::new);
    }


    public Recette save(Recette recette) {
        return recetteRepository.save(recette);
    }


    public void deleteById(Long id) {
        recetteRepository.findById(id)
                .orElseThrow(RecetteNotFoundException::new);
        recetteRepository.deleteById(id);
    }


    public Recette updateRecetteById(Recette recette, Long id) {
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
