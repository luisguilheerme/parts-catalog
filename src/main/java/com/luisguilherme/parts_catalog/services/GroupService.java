package com.luisguilherme.parts_catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.GroupDTO;
import com.luisguilherme.parts_catalog.entities.Group;
import com.luisguilherme.parts_catalog.repositories.GroupRepository;
import com.luisguilherme.parts_catalog.services.exceptions.DatabaseException;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupService {
	
	@Autowired
	GroupRepository repository;	
	
	@Transactional(readOnly = true)
	public GroupDTO findById(Long id) {		
		Group product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Grupo não encontrado") );
		return new GroupDTO(product);
	}
	
	@Transactional(readOnly = true)
	public List<GroupDTO> findAll() {
		List<Group> result = repository.findAll();
		return result.stream().map(x -> new GroupDTO(x)).toList();
	}
	
	@Transactional
	public GroupDTO insert(GroupDTO dto) {
		Group entity = new Group();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new GroupDTO(entity);		
	}

	@Transactional
	public GroupDTO update(Long id, GroupDTO dto) {
		try {
			Group entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new GroupDTO(entity);
		}
		catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Grupo não encontrado");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Grupo não encontrado");
		}
		try {			
			repository.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Não é possível apagar o grupo, pois existem subgrupos vinculados.");
		}		
	}
	
}
