package com.luisguilherme.parts_catalog.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.luisguilherme.parts_catalog.entities.Part;

public class PartQueryFilter {
    
    private String code;
    private String originalCode;
    private String starterAlternatorCode;
    private String manufacturer;
    private String group;
    private String subGroup;
    private String model;
    private String brand;
    
    public Specification<Part> toSpecification() {    
    	return PartSpecifications.codeContains(code)
				.and(PartSpecifications.originalCodeContains(originalCode))
				.and(PartSpecifications.starterAlternatorCodeContains(starterAlternatorCode))	
				.and(PartSpecifications.manufacturerEquals(manufacturer))
				.and(PartSpecifications.subGroupEquals(subGroup))
				.and(PartSpecifications.groupEquals(group))
				.and(PartSpecifications.modelEquals(model))
				.and(PartSpecifications.brandEquals(brand));     	
    }
        
    public String getCode() {
        return code;
    }
    
    public String getOriginalCode() {
        return originalCode;
    }
    
    public String getStarterAlternatorCode() {
        return starterAlternatorCode;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }   
    
    public String getSubGroup() {
		return subGroup;
	}
    
    public String getGroup() {
		return group;
	}

	public String getModel() {
		return model;
	}

	public String getBrand() {
		return brand;
	}
	
	public void setCode(String code) {
        this.code = code;
    }

    public void setOriginalCode(String originalCode) {
        this.originalCode = originalCode;
    }

    public void setStarterAlternatorCode(String starterAlternatorCode) {
        this.starterAlternatorCode = starterAlternatorCode;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    
    public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}
    
    public void setGroup(String group) {
		this.group = group;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
}
