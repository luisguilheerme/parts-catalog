package com.luisguilherme.parts_catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisguilherme.parts_catalog.entities.SubGroup;

@Repository
public interface SubGroupRepository extends JpaRepository <SubGroup, Long>{

	List<SubGroup> findAllByGroupId(Long groupId);
}
