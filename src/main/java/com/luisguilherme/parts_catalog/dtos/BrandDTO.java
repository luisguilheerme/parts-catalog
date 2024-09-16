package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Brand;

public class BrandDTO {
	
	private Long id;
	private String name;
	
	public BrandDTO() {
		
	}

	public BrandDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public BrandDTO(Brand entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
