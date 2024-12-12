package com.luisguilherme.parts_catalog.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.luisguilherme.parts_catalog.dtos.ApplicationDTO;
import com.luisguilherme.parts_catalog.dtos.CodeDTO;
import com.luisguilherme.parts_catalog.dtos.PartDTO;
import com.luisguilherme.parts_catalog.dtos.PartDetailDTO;
import com.luisguilherme.parts_catalog.dtos.PartMinDTO;
import com.luisguilherme.parts_catalog.services.PartService;
import com.luisguilherme.parts_catalog.specifications.PartQueryFilter;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/parts")
@Tag(name = "Parts")
public class PartController {
	
	@Autowired
	PartService service;

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<PartDetailDTO> findById(@PathVariable Long id) {
		PartDetailDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<PartMinDTO>> findAll(PartQueryFilter filter, Pageable pageable) {
		Page<PartMinDTO> dto = service.findAll(filter, pageable);
		return ResponseEntity.ok(dto);
	}	
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(produces = "application/json")
	public ResponseEntity<PartDTO> insert(@Valid @RequestBody PartDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<PartDTO> update(@PathVariable Long id, @Valid @RequestBody PartDTO dto) {
		dto = service.update(id, dto);		
		return ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping(value = "/{id}/applications", produces = "application/json")
	public ResponseEntity<ApplicationDTO> addApplication(@PathVariable Long id, @Valid @RequestBody ApplicationDTO dto) {
		service.addApplication(dto, id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping(value = "/{id}/codes", produces = "application/json")
	public ResponseEntity<CodeDTO> addCode(@PathVariable Long id, @Valid @RequestBody CodeDTO code) {
		service.addCode(code, id);
		return ResponseEntity.ok(code);
	}
	
	@PostMapping(value = "/{id}/original-codes", produces = "application/json")
	public ResponseEntity<CodeDTO> addOriginalCode(@PathVariable Long id, @Valid @RequestBody CodeDTO code) {
		service.addOriginalCode(code, id);
		return ResponseEntity.ok(code);
	}
	
	@PostMapping(value = "/{id}/starter-alternator-codes", produces = "application/json")
	public ResponseEntity<CodeDTO> addStarterAlternatorCode(@PathVariable Long id, @Valid @RequestBody CodeDTO code) {
		service.addStarterAlternatorCode(code, id);
		return ResponseEntity.ok(code);
	}

}
