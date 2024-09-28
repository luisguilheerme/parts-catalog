package com.luisguilherme.parts_catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.ModelDTO;
import com.luisguilherme.parts_catalog.entities.Brand;
import com.luisguilherme.parts_catalog.entities.Model;
import com.luisguilherme.parts_catalog.repositories.BrandRepository;
import com.luisguilherme.parts_catalog.repositories.ModelRepository;
import com.luisguilherme.parts_catalog.services.exceptions.DatabaseException;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ModelService {
	
	@Autowired
	ModelRepository repository;	
	
	@Autowired
	BrandRepository brandRepository;	
	
	@Transactional(readOnly = true)
	public ModelDTO findById(Long id) {		
		Model product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Modelo não encontrado") );
		return new ModelDTO(product);
	}
	
	@Transactional(readOnly = true)
	public List<ModelDTO> findAll(Long brandId) {
		if (!brandRepository.existsById(brandId)) {
			throw new ResourceNotFoundException("Marca não encontrada");
		}		
		List<Model> result = repository.findAllByBrandId(brandId);
		return result.stream().map(x -> new ModelDTO(x)).toList();	
	}
	
	@Transactional
	public ModelDTO insert(Long brandId, ModelDTO dto) {
		if (!brandRepository.existsById(brandId)) {
			throw new ResourceNotFoundException("Marca não encontrada");
		}		
		Model entity = new Model();
		entity.setName(dto.getName());
		Brand brand = brandRepository.getReferenceById(brandId);
		entity.setBrand(brand);			
		entity = repository.save(entity);
		return new ModelDTO(entity);		
	}

	@Transactional
	public ModelDTO update(Long id, ModelDTO dto) {
		try {
			Model entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new ModelDTO(entity);
		}
		catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Modelo não encontrado");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Modelo não encontrado");
		}		
		try {			
			repository.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Não é possível apagar o modelo, pois existem aplicações vinculadas.");
		}		
	}
	
}
