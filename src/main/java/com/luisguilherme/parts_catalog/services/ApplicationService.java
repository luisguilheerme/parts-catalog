package com.luisguilherme.parts_catalog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.ApplicationDTO;
import com.luisguilherme.parts_catalog.entities.Application;
import com.luisguilherme.parts_catalog.entities.Model;
import com.luisguilherme.parts_catalog.entities.Part;
import com.luisguilherme.parts_catalog.repositories.ApplicationRepository;
import com.luisguilherme.parts_catalog.repositories.PartRepository;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ApplicationService {
	
	@Autowired
	ApplicationRepository repository;
	
	@Autowired
	PartRepository partRepository;
	
			
	@Transactional
	public Application insert(Part part, ApplicationDTO dto) {
	    Application entity = new Application();
	    copyDtoToEntity(dto, entity);
	    entity.setPart(part);
	    return repository.save(entity); 	    
	}

	@Transactional
	public ApplicationDTO update(Long id, ApplicationDTO dto) {
		try {
			Application entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ApplicationDTO(entity);
		}
		catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Aplicação não encontrada");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Aplicação não encontrada");
		}		
			repository.deleteById(id);		
	}
	
	private void copyDtoToEntity(ApplicationDTO dto, Application entity) {
		entity.setObs(dto.getObs());
		entity.setStartingYear(dto.getStartingYear());
		entity.setFinalYear(dto.getFinalYear());
		Model model = new Model();
	    model.setId(dto.getModel().getId());
	    model.setName(dto.getModel().getName());
	    entity.setModel(model);
	}
	
}
