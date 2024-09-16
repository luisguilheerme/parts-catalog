package com.luisguilherme.parts_catalog.dtos;

import java.util.ArrayList;
import java.util.List;

import com.luisguilherme.parts_catalog.entities.Application;
import com.luisguilherme.parts_catalog.entities.Code;
import com.luisguilherme.parts_catalog.entities.OriginalCode;
import com.luisguilherme.parts_catalog.entities.Part;
import com.luisguilherme.parts_catalog.entities.StarterAlternator;

import jakarta.validation.constraints.NotBlank;

public class PartDTO {

	private Long id;
	@NotBlank(message = "Campo Obrigatório")
	private String description;
	private String imgUrl;
    private String manufacturerName;
    private SubGroupDTO subGroupDTO;

    
    private List<String> codes = new ArrayList<>();
    private List<String> originalCodes = new ArrayList<>();
    private List<String> starterAlternatorCodes = new ArrayList<>();
    private List<ApplicationDTO> applications = new ArrayList<>();
	
	public PartDTO() {
		
	}

	public PartDTO(Long id, String description, String imgUrl, String manufacturerName, SubGroupDTO subGroupDTO) {
	    this.id = id;
	    this.description = description;
	    this.imgUrl = imgUrl;
	    this.manufacturerName = manufacturerName;
	    this.subGroupDTO = subGroupDTO;
	}

	public PartDTO(Part entity) {
	    id = entity.getId();
	    description = entity.getDescription();
	    imgUrl = entity.getImgUrl();
	    manufacturerName = entity.getManufacturer().getName();
	    
	    subGroupDTO = new SubGroupDTO(entity.getSubGroup());
	    
	    for (Code c : entity.getCodes()) {
	    	codes.add(c.getCode()); 
	    }
	    for (OriginalCode oc : entity.getOriginalCodes()) {
	    	originalCodes.add(oc.getCode()); 
	    }
	    for (StarterAlternator sa : entity.getStartersAlternators()) {
	    	starterAlternatorCodes.add(sa.getCode()); 
	    }
		for (Application a : entity.getApplications()) {
			applications.add(new ApplicationDTO(a));
		}
	}


	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getImgUrl() {
		return imgUrl;
	}
	
	public String getManifactureName() {
		return manufacturerName;
	}	

	public SubGroupDTO getSubGroupDTO() {
		return subGroupDTO;
	}

	public List<String> getCodes() {
		return codes;
	}

	public List<String> getOriginalCodes() {
		return originalCodes;
	}

	public List<String> getStartersAlternators() {
		return starterAlternatorCodes;
	}

	public List<ApplicationDTO> getApplications() {
		return applications;
	}
	
}

