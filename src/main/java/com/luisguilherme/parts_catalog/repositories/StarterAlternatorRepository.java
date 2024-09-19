package com.luisguilherme.parts_catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisguilherme.parts_catalog.entities.StarterAlternator;

@Repository
public interface StarterAlternatorRepository extends JpaRepository <StarterAlternator, Long>{

}
