package com.luisguilherme.parts_catalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.luisguilherme.parts_catalog.dtos.SubGroupDTO;
import com.luisguilherme.parts_catalog.entities.Group;
import com.luisguilherme.parts_catalog.entities.SubGroup;
import com.luisguilherme.parts_catalog.repositories.GroupRepository;
import com.luisguilherme.parts_catalog.repositories.SubGroupRepository;
import com.luisguilherme.parts_catalog.services.exceptions.DatabaseException;
import com.luisguilherme.parts_catalog.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SubGroupService {
	
	@Autowired
	SubGroupRepository repository;	
	
	@Autowired
	GroupRepository groupRepository;	
	
	@Transactional(readOnly = true)
	public SubGroupDTO findById(Long id) {		
		SubGroup product = repository.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Sub Grupo não encontrado") );
		return new SubGroupDTO(product);
	}
	
	@Transactional(readOnly = true)
	public List<SubGroupDTO> findAll(Long groupId) {
		if (!groupRepository.existsById(groupId)) {
			throw new ResourceNotFoundException("Grupo não encontrado");
		}		
		List<SubGroup> result = repository.findAllByGroupId(groupId);
		return result.stream().map(x -> new SubGroupDTO(x)).toList();	
	}
	
	@Transactional
	public SubGroupDTO insert(Long groupId, SubGroupDTO dto) {
		if (!groupRepository.existsById(groupId)) {
			throw new ResourceNotFoundException("Grupo não encontrado");
		}		
		SubGroup entity = new SubGroup();
		entity.setName(dto.getName());
		Group group = groupRepository.getReferenceById(groupId);
		entity.setGroup(group);			
		entity = repository.save(entity);
		return new SubGroupDTO(entity);		
	}

	@Transactional
	public SubGroupDTO update(Long id, SubGroupDTO dto) {
		try {
			SubGroup entity = repository.getReferenceById(id);
			entity.setName(dto.getName());
			entity = repository.save(entity);
			return new SubGroupDTO(entity);
		}
		catch(EntityNotFoundException e){
				throw new ResourceNotFoundException("Sub Grupo não encontrado");
		}
	}
	
	@Transactional(propagation = Propagation.SUPPORTS)
	public void delete(Long id) {
		if (!repository.existsById(id)) {
			throw new ResourceNotFoundException("Sub Grupo não encontrado");
		}		
		try {			
			repository.deleteById(id);	
		}
		catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Não é possível apagar o sub grupo, pois existem peças vinculadas.");
		}		
	}
	
}
