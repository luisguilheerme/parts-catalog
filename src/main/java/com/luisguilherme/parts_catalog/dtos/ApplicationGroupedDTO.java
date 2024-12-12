package com.luisguilherme.parts_catalog.dtos;

import java.util.List;

public class ApplicationGroupedDTO {
	
	private String brand;
    private List<ApplicationDTO> applications;
    
    public ApplicationGroupedDTO() {
    	
    }
    
    public ApplicationGroupedDTO(String brand, List<ApplicationDTO> applications) {
        this.brand = brand;
        this.applications = applications;
    }

    public String getBrand() {
        return brand;
    }

    public List<ApplicationDTO> getApplications() {
        return applications;
    }   

}
