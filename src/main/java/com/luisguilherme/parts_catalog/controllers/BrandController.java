package com.luisguilherme.parts_catalog.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.luisguilherme.parts_catalog.dtos.BrandDTO;
import com.luisguilherme.parts_catalog.services.BrandService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/brands")
@Tag(name = "Brands")
public class BrandController {
	
	@Autowired
	BrandService service;	
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<BrandDTO> findById(@PathVariable Long id) {
		BrandDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}	
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<List<BrandDTO>> findAll() {
		List<BrandDTO> dto = service.findAll();
		return ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(produces = "application/json")
	public ResponseEntity<BrandDTO> insert(@Valid @RequestBody BrandDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<BrandDTO> update(@PathVariable Long id, @Valid @RequestBody BrandDTO dto) {
		dto = service.update(id, dto);		
		return ResponseEntity.ok(dto);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
