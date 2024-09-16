package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Application;

public class ApplicationDTO {
	
	private Long id;
	private String obs;
	private Integer startingYear;
	private Integer finalYear;
	private ModelDTO modelDTO;
	
	public ApplicationDTO() {
		
	}

	public ApplicationDTO(Long id, String obs, Integer startingYear, Integer finalYear, ModelDTO modelDTO) {
		this.id = id;
		this.obs = obs;
		this.startingYear = startingYear;
		this.finalYear = finalYear;
		this.modelDTO = modelDTO;
	}
	
	public ApplicationDTO(Application entity) {
		id = entity.getId();
		obs = entity.getObs();
		startingYear = entity.getStartingYear();
		finalYear = entity.getFinalYear();
		modelDTO = new ModelDTO(entity.getModel());
	}

	public Long getId() {
		return id;
	}

	public String getObs() {
		return obs;
	}

	public Integer getStartingYear() {
		return startingYear;
	}

	public Integer getFinalYear() {
		return finalYear;
	}

	public ModelDTO getModelDTO() {
		return modelDTO;
	}

}
