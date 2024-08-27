package com.cook.organization.service;

import com.cook.organization.entity.Recette;
import com.cook.organization.exception.RecetteIdMismatchException;
import com.cook.organization.exception.RecetteNotFoundException;
import com.cook.organization.repository.IRecetteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecetteService {

    @Autowired
    private IRecetteRepository recetteRepository;


    public Iterable findAll() {
        return recetteRepository.findAll();
    }

    public List findByTitre(String recetteTitre) {
        return recetteRepository.findByTitre(recetteTitre);
    }

    public Recette findById(Long id)  {
        try {
            return recetteRepository.findById(id)
                    .orElseThrow(RecetteNotFoundException::new);
        } catch (RecetteNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public Recette save(Recette recette) {
        recette.validate();
        return recetteRepository.save(recette);
    }


    public void deleteById(Long id) {
        try {
            recetteRepository.findById(id)
                    .orElseThrow(RecetteNotFoundException::new);
        } catch (RecetteNotFoundException e) {
            throw new RuntimeException(e);
        }
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
        try {
            recetteRepository.findById(id)
                    .orElseThrow(RecetteNotFoundException::new);
        } catch (RecetteNotFoundException e) {
            throw new RuntimeException(e);
        }
        return recetteRepository.save(recette);
    }

}
