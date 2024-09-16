package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.SubGroup;

import jakarta.validation.constraints.NotBlank;

public class SubGroupDTO {
	
	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	private GroupDTO groupDTO;
	
	public SubGroupDTO() {
		
	}

	public SubGroupDTO(Long id, String name, GroupDTO groupDTO) {
		this.id = id;
		this.name = name;
		this.groupDTO =groupDTO;
	}
	
	public SubGroupDTO(SubGroup entity) {
		id = entity.getId();
		name = entity.getName();
		groupDTO = new GroupDTO(entity.getGroup());
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public GroupDTO getGroupDTO() {
		return groupDTO;
	}

}
