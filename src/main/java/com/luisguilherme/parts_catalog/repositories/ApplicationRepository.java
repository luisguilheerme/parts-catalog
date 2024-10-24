package com.luisguilherme.parts_catalog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luisguilherme.parts_catalog.entities.Application;

@Repository
public interface ApplicationRepository extends JpaRepository <Application, Long>{

	List<Application> findAllByPartId(Long partId);
}
