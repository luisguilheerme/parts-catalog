package com.luisguilherme.parts_catalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.ApplicationDTO;
import com.luisguilherme.parts_catalog.dtos.CodeDTO;
import com.luisguilherme.parts_catalog.dtos.PartDTO;
import com.luisguilherme.parts_catalog.entities.Application;
import com.luisguilherme.parts_catalog.entities.Manufacturer;
import com.luisguilherme.parts_catalog.entities.Model;
import com.luisguilherme.parts_catalog.entities.Part;
import com.luisguilherme.parts_catalog.entities.SubGroup;
import com.luisguilherme.parts_catalog.repositories.PartRepository;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;
import com.luisguilherme.parts_catalog.specifications.PartQueryFilter;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PartService {

	@Autowired
	private PartRepository repository;
	
	@Autowired
	private ApplicationService applicationService;
	
	@Transactional(readOnly = true)
	public PartDTO findById(Long id) {
		Part part = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Peça não encontrada") );
		return new PartDTO(part);
	}
	
	@Transactional(readOnly = true)
	public Page<PartDTO> findAll(PartQueryFilter filter, Pageable pageable) {
		Page<Part> result = repository.findAll(filter.toSpecification(), pageable);
		return result.map(x -> new PartDTO(x));
	}
	
	@Transactional
	public PartDTO insert(PartDTO dto) {
		Part entity = new Part();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new PartDTO(entity);
	}
	
	@Transactional
	public PartDTO update(Long id, PartDTO dto) {
		try {
			Part entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new PartDTO(entity);			
		}
		catch(EntityNotFoundException e){
			throw new ResourceNotFoundException("Peça não encontrada");
		}		
	}		
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Peça não encontrada");
		}					
		repository.deleteById(id);	
	}
	
	@Transactional
	public ApplicationDTO addApplication(ApplicationDTO applicationDTO, Long partId) {
		Part part = repository.findById(partId).orElseThrow(
				() -> new ResourceNotFoundException("Peça não encontrada"));

	    Application application = applicationService.insert(part, applicationDTO);
	    part.getApplications().add(application);
	    part = repository.save(part);

	    return new ApplicationDTO(application);	        
	}
	
	@Transactional
	public CodeDTO addCode(CodeDTO code, Long partId) {
		Part part = repository.findById(partId).orElseThrow(
				() -> new ResourceNotFoundException("Peça não encontrada"));
		part.getCodes().add(code.getCode());
		part = repository.save(part);
		return code;
	}
	
	@Transactional
	public CodeDTO addOriginalCode(CodeDTO code, Long partId) {
		Part part = repository.findById(partId).orElseThrow(
				() -> new ResourceNotFoundException("Peça não encontrada"));
		part.getOriginalCodes().add(code.getCode());
		part = repository.save(part);
		return code;
	}
	
	@Transactional
	public CodeDTO addStarterAlternatorCode(CodeDTO code, Long partId) {
		Part part = repository.findById(partId).orElseThrow(
				() -> new ResourceNotFoundException("Peça não encontrada"));
		part.getStartersAlternatorsCodes().add(code.getCode());
		part = repository.save(part);
		return code;
	}	
		
	private void copyDtoToEntity(PartDTO dto, Part entity) {
		entity.setDescription(dto.getDescription());
		entity.setImgUrl(dto.getImgUrl());
		
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setId(dto.getManufacturer().getId());
		manufacturer.setName(dto.getManufacturer().getName());
		
		SubGroup subGroup = new SubGroup();
		subGroup.setId(dto.getSubGroup().getId());
		subGroup.setName(dto.getSubGroup().getName());		
		
		entity.setManufacturer(manufacturer);
		entity.setSubGroup(subGroup);
		
		entity.getCodes().clear();
		
		for(String c : dto.getCodes()) {			
			entity.getCodes().add(c);
		}
		
		entity.getOriginalCodes().clear();
		
		for(String oc : dto.getOriginalCodes()) {			
			entity.getOriginalCodes().add(oc);
		}
		
		entity.getStartersAlternatorsCodes().clear();
		
		for(String sa : dto.getStartersAlternatorsCodes()) {			
			entity.getStartersAlternatorsCodes().add(sa);
		}
		
		entity.getApplications().clear();		
		
		for(ApplicationDTO appDto : dto.getApplications()) {	
			 Application application = new Application();
		        
		     Model model = new Model();
		     model.setId(appDto.getModel().getId());
		     model.setName(appDto.getModel().getName());		   
		        
		     application.setModel(model);
		     application.setStartingYear(appDto.getStartingYear());
		     application.setFinalYear(appDto.getFinalYear());
		     application.setObs(appDto.getObs());
		     application.setPart(entity);
		        
		     entity.getApplications().add(application);		
		}
		
	}
}
