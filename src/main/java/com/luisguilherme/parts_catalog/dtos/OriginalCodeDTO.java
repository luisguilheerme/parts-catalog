package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.OriginalCode;

import jakarta.validation.constraints.NotBlank;

public class OriginalCodeDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String code;
	
	public OriginalCodeDTO() {
		
	}

	public OriginalCodeDTO(Long id, String code) {
		this.id = id;
		this.code = code;
	}
	
	public OriginalCodeDTO(OriginalCode entity) {
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