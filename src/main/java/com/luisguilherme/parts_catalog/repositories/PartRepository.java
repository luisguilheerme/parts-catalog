package com.luisguilherme.parts_catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.luisguilherme.parts_catalog.entities.Part;

@Repository
public interface PartRepository extends JpaRepository <Part, Long>, JpaSpecificationExecutor<Part>{

}
