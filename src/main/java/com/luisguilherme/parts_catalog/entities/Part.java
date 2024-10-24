package com.luisguilherme.parts_catalog.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
	
	@ElementCollection
	@CollectionTable(name = "part_code", joinColumns = @JoinColumn(name = "part_id"))
	@Column(name = "code")
	private List<String> codes = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "part_original_code", joinColumns = @JoinColumn(name = "part_id"))
	@Column(name = "original_code")
	private List<String> originalCodes = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "part_starter_alternator", joinColumns = @JoinColumn(name = "part_id"))
	@Column(name = "starter_alternator")
	private List<String> startersAlternatorsCodes = new ArrayList<>();
	    
	@OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
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

	public List<String> getCodes() {
		return codes;
	}

	public List<String> getOriginalCodes() {
		return originalCodes;
	}

	public List<String> getStartersAlternatorsCodes() {
		return startersAlternatorsCodes;
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
