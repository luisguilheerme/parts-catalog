package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Group;

import jakarta.validation.constraints.NotBlank;

public class GroupDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	
	public GroupDTO() {
		
	}

	public GroupDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public GroupDTO(Group entity) {
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
