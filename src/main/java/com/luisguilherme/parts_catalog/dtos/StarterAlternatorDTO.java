package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.StarterAlternator;

import jakarta.validation.constraints.NotBlank;

public class StarterAlternatorDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String code;
	
	public StarterAlternatorDTO() {
		
	}

	public StarterAlternatorDTO(Long id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public StarterAlternatorDTO(StarterAlternator entity) {
		id = entity.getId();
		code = entity.getCode();
	}

	public Long getId() {
		return id;
	}

	public String getCode() {
		return code;
	}
	
}
