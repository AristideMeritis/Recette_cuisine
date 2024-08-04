package com.cook.organization.dao;

import com.cook.organization.entity.Personne;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IDao<T> {

    Optional <T> get(UUID id);

    List<T> getAll();

    void save(T t);

    void save(Personne person);

    void update(T t, String[] params);

    void delete (T t);
}
