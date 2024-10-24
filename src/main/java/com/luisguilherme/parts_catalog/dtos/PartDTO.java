package com.luisguilherme.parts_catalog.dtos;

import java.util.ArrayList;
import java.util.List;

import com.luisguilherme.parts_catalog.entities.Application;
import com.luisguilherme.parts_catalog.entities.Part;

import jakarta.validation.constraints.NotBlank;

public class PartDTO {

	private Long id;
	
	@NotBlank(message = "Campo Obrigatório")
	private String description;
	
	private String imgUrl;	
    private ManufacturerDTO manufacturer;
    private SubGroupDTO subGroup;
	
    private List<ApplicationDTO> applications = new ArrayList<>();    
    private List<String> codes = new ArrayList<>();
    private List<String> originalCodes = new ArrayList<>();
    private List<String> starterAlternatorCodes = new ArrayList<>();
    
	
	public PartDTO() {
		
	}

	public PartDTO(Long id, String description, String imgUrl, ManufacturerDTO manufacturer, SubGroupDTO subGroup) {
	    this.id = id;
	    this.description = description;
	    this.imgUrl = imgUrl;
	    this.manufacturer = manufacturer;
	    this.subGroup = subGroup;
	}

	public PartDTO(Part entity) {
	    id = entity.getId();
	    description = entity.getDescription();
	    imgUrl = entity.getImgUrl();
	    
	    manufacturer = new ManufacturerDTO(entity.getManufacturer());	    
	    subGroup = new SubGroupDTO(entity.getSubGroup());
	    
	    for (String c : entity.getCodes()) {
	    	codes.add(c); 
	    }
	    for (String oc : entity.getOriginalCodes()) {
	    	originalCodes.add(oc); 
	    }
	    for (String sac : entity.getStartersAlternatorsCodes()) {
	    	starterAlternatorCodes.add(sac); 
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
	
	public ManufacturerDTO getManufacturer() {
		return manufacturer;
	}	

	public SubGroupDTO getSubGroup() {
		return subGroup;
	}

	public List<String> getCodes() {
		return codes;
	}

	public List<String> getOriginalCodes() {
		return originalCodes;
	}

	public List<String> getStartersAlternatorsCodes() {
		return starterAlternatorCodes;
	}

	public List<ApplicationDTO> getApplications() {
		return applications;
	}
	
}

