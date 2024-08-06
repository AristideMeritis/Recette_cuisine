package com.cook.organization.repository;

import com.cook.organization.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IIngredientRepository extends CrudRepository<Ingredient,Long> {
}
