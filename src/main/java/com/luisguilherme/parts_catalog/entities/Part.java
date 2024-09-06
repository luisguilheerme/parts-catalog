package com.luisguilherme.parts_catalog.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_part")
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String description;
	private String imgUrl;
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;
	
	@ManyToOne
	@JoinColumn(name = "subgroup_id")
	private SubGroup subGroup;
	
	@OneToMany(mappedBy = "part")
	private List<Code> codes = new ArrayList<>();
	
	@OneToMany(mappedBy = "part")
	private List<OriginalCode> originalCodes = new ArrayList<>();
	
	@OneToMany(mappedBy = "part")
	private List<StarterAlternator> startersAlternators = new ArrayList<>();
	
	@OneToMany(mappedBy = "part")
	private List<Application> applications = new ArrayList<>();
	
	public Part() {
		
	}

	public Part(Long id, String description, String imgUrl, Manufacturer manufacturer, SubGroup subGroup) {
		this.id = id;
		this.description = description;
		this.imgUrl = imgUrl;
		this.subGroup = subGroup;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}	

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}	

	public SubGroup getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(SubGroup subGroup) {
		this.subGroup = subGroup;
	}

	public List<Code> getCodes() {
		return codes;
	}

	public List<OriginalCode> getOriginalCodes() {
		return originalCodes;
	}

	public List<StarterAlternator> getStartersAlternators() {
		return startersAlternators;
	}

	public List<Application> getApplications() {
		return applications;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Part other = (Part) obj;
		return Objects.equals(id, other.id);
	}	
	
}
