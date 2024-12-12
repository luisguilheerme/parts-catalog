package com.luisguilherme.parts_catalog.dtos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.luisguilherme.parts_catalog.entities.Application;
import com.luisguilherme.parts_catalog.entities.Part;

public class PartDetailDTO {
	
	private Long id;
	private String description;	
	private String imgUrl;	
    private String manufacturer;
    private String subGroup;
	
    private List<ApplicationGroupedDTO> applications;  
    private List<String> codes = new ArrayList<>();
    private List<String> originalCodes = new ArrayList<>();
    private List<String> starterAlternatorCodes = new ArrayList<>();
    
	
	public PartDetailDTO() {
		
	}

	public PartDetailDTO(Long id, String description, String imgUrl, String manufacturer, String subGroup) {
	    this.id = id;
	    this.description = description;
	    this.imgUrl = imgUrl;
	    this.manufacturer = manufacturer;
	    this.subGroup = subGroup;
	}

	public PartDetailDTO(Part entity) {
	    id = entity.getId();
	    description = entity.getDescription();
	    imgUrl = entity.getImgUrl();
	    
	    manufacturer = entity.getManufacturer().getName();	    
	    subGroup = entity.getSubGroup().getName();
	    
	    this.applications = groupApplications(entity.getApplications());
	    
	    for (String c : entity.getCodes()) {
	    	codes.add(c); 
	    }
	    for (String oc : entity.getOriginalCodes()) {
	    	originalCodes.add(oc); 
	    }
	    for (String sac : entity.getStartersAlternatorsCodes()) {
	    	starterAlternatorCodes.add(sac); 
	    }   

	}
	
	private List<ApplicationGroupedDTO> groupApplications(List<Application> applications) {
	    if (applications == null || applications.isEmpty()) {
	        return new ArrayList<>();
	    }	    
	    
	    Map<String, List<Application>> groupedByBrand = applications.stream()
	            .collect(Collectors.groupingBy(app -> app.getModel().getBrand().getName()));

	    return groupedByBrand.entrySet().stream()
	            .map(entry -> {
	                List<ApplicationDTO> applicationDTOs = entry.getValue().stream()
	                        .map(ApplicationDTO::new)  
	                        .collect(Collectors.toList());

	                
	                return new ApplicationGroupedDTO(entry.getKey(), applicationDTOs);
	            })
	            .sorted(Comparator.comparing(ApplicationGroupedDTO::getBrand)).toList();
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
	
	public String getManufacturer() {
		return manufacturer;
	}	

	public String getSubGroup() {
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

	public List<ApplicationGroupedDTO> getApplications() {
		return applications;
	}

}
