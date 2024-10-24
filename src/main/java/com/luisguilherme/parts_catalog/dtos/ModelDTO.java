package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Model;

import jakarta.validation.constraints.NotBlank;

public class ModelDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	public ModelDTO() {
		
	}	

	public ModelDTO(Long id, String name) {
		this.id = id;
		this.name = name;
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

}