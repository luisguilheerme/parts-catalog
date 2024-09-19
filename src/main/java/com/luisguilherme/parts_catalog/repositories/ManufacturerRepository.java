package com.luisguilherme.parts_catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisguilherme.parts_catalog.entities.Manufacturer;

@Repository
public interface ManufacturerRepository extends JpaRepository <Manufacturer, Long>{

}
