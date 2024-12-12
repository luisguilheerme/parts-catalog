package com.luisguilherme.parts_catalog.dtos;

import com.luisguilherme.parts_catalog.entities.Part;

public class PartMinDTO {
	
	private Long id;	
	private String imgUrl;	
    private String subGroup;
	
	public PartMinDTO() {
		
	}

	public PartMinDTO(Long id, String imgUrl,String subGroup) {
	    this.id = id;	    
	    this.imgUrl = imgUrl;
	    this.subGroup = subGroup;
	}

	public PartMinDTO(Part entity) {
	    id = entity.getId();
	    imgUrl = entity.getImgUrl();	       
	    subGroup = entity.getSubGroup().getName();	    
	}

	public Long getId() {
		return id;
	}

	public String getImgUrl() {
		return imgUrl;
	}	

	public String getSubGroup() {
		return subGroup;
	}


}
