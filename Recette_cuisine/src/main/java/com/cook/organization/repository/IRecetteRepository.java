package com.cook.organization.repository;


import com.cook.organization.entity.Recette;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IRecetteRepository  extends JpaRepository<Recette, Long> {

    List findByTitre(String recetteTitre);
}
