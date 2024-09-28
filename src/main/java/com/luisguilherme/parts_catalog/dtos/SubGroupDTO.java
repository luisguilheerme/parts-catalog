package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.SubGroup;

import jakarta.validation.constraints.NotBlank;

public class SubGroupDTO {
	
	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	public SubGroupDTO() {
		
	}

	public SubGroupDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public SubGroupDTO(SubGroup entity) {
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
