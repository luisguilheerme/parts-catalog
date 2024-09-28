package com.luisguilherme.parts_catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.ManufacturerDTO;
import com.luisguilherme.parts_catalog.entities.Manufacturer;
import com.luisguilherme.parts_catalog.repositories.ManufacturerRepository;
import com.luisguilherme.parts_catalog.services.exceptions.DatabaseException;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ManufacturerService {
	
	@Autowired
	ManufacturerRepository repository;	
	
	@Transactional(readOnly = true)
	public ManufacturerDTO findById(Long id) {		
		Manufacturer product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Fabricante não encontrado") );
		return new ManufacturerDTO(product);
	}
	
	@Transactional(readOnly = true)
	public List<ManufacturerDTO> findAll() {
		List<Manufacturer> result = repository.findAll();
		return result.stream().map(x -> new ManufacturerDTO(x)).toList();
	}
	
	@Transactional
	public ManufacturerDTO insert(ManufacturerDTO dto) {
		Manufacturer entity = new Manufacturer();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new ManufacturerDTO(entity);		
	}

	@Transactional
	public ManufacturerDTO update(Long id, ManufacturerDTO dto) {
		try {
			Manufacturer entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new ManufacturerDTO(entity);
		}
		catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Fabricante não encontrado");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Fabricante não encontrado");
		}
		try {			
			repository.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Não é possível apagar o Fabricante, pois existem peças vinculadas.");
		}		
	}
	
}
