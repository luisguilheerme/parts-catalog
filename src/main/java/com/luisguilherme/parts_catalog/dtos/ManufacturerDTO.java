package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Manufacturer;

import jakarta.validation.constraints.NotBlank;

public class ManufacturerDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	public ManufacturerDTO() {
		
	}

	public ManufacturerDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public ManufacturerDTO(Manufacturer entity) {
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