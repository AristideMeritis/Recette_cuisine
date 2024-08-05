package com.cook.organization.repository;


import com.cook.organization.entity.Recette;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RecetteRepository  extends CrudRepository<Recette, Long> {
    @Override
    Optional<Recette> findById(Long aLong);

    @Override
    default <S extends Recette> S save(S entity) {
        return null;
    }

    @Override
    default <S extends Recette> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    default boolean existsById(Long aLong) {
        return false;
    }

    @Override
    default Iterable<Recette> findAll() {
        return null;
    }

    @Override
    default Iterable<Recette> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    default long count() {
        return 0;
    }

    @Override
    default void deleteById(Long aLong) {

    }

    @Override
    default void delete(Recette entity) {

    }

    @Override
    default void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    default void deleteAll(Iterable<? extends Recette> entities) {

    }

    @Override
    default void deleteAll() {

    }

    List findByTitre(String recetteTitre);
}
