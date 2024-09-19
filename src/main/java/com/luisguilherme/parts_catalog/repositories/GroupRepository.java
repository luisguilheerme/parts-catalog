package com.luisguilherme.parts_catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.luisguilherme.parts_catalog.entities.Group;

@Repository
public interface GroupRepository extends JpaRepository <Group, Long>{

}
