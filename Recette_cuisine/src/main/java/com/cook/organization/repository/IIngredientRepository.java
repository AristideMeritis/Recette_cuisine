package com.cook.organization.repository;

import com.cook.organization.entity.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;


public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

    @Query("SELECT ing FROM Ingredient ing where ing.name = ?1")
    Optional<Ingredient> findIngredientByName(String name);
}
