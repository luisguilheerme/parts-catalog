package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Model;

import jakarta.validation.constraints.NotBlank;

public class ModelDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	private BrandDTO brandDTO;
	
	public ModelDTO() {
		
	}	

	public ModelDTO(Long id, String name, BrandDTO brandDTO) {
		this.id = id;
		this.name = name;
		this.brandDTO = brandDTO;
	}

	public ModelDTO(Model entity) {
		id = entity.getId();
		name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BrandDTO getBrandDTO() {
		return brandDTO;
	}

}