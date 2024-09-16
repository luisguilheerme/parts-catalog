package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Code;

import jakarta.validation.constraints.NotBlank;

public class CodeDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String code;
	
	public CodeDTO() {
		
	}

	public CodeDTO(Long id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public CodeDTO(Code entity) {
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