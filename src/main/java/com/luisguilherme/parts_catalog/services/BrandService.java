package com.luisguilherme.parts_catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.BrandDTO;
import com.luisguilherme.parts_catalog.entities.Brand;
import com.luisguilherme.parts_catalog.repositories.BrandRepository;
import com.luisguilherme.parts_catalog.services.exceptions.DatabaseException;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BrandService {
	
	@Autowired
	BrandRepository repository;	
	
	@Transactional(readOnly = true)
	public BrandDTO findById(Long id) {		
		Brand product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Marca não encontrado") );
		return new BrandDTO(product);
	}
	
	@Transactional(readOnly = true)
	public List<BrandDTO> findAll() {
		List<Brand> result = repository.findAll();
		return result.stream().map(x -> new BrandDTO(x)).toList();
	}
	
	@Transactional
	public BrandDTO insert(BrandDTO dto) {
		Brand entity = new Brand();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new BrandDTO(entity);		
	}

	@Transactional
	public BrandDTO update(Long id, BrandDTO dto) {
		try {
			Brand entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new BrandDTO(entity);
		}
		catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Marca não encontrada");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Marca não encontrada");
		}
		try {			
			repository.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Não é possível apagar a marca, pois existem modelos vinculados.");
		}		
	}
	
}
