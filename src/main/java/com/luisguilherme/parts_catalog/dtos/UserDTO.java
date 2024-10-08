package com.luisguilherme.parts_catalog.dtos;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;

import com.luisguilherme.parts_catalog.entities.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UserDTO {

	private Long id;
	@Size(min = 2, max = 80, message = "O nome deve ter de 2 a 80 caracteres" )
	@NotBlank(message = "Campo Obrigatório")
	private String name;
	@Email(message = "Email inválido")
	@NotBlank(message = "Campo obrigatório")
	private String email;
	@NotBlank(message = "Campo obrigatório")
	private String password;

	private List<String> roles = new ArrayList<>();

	public UserDTO() {

	}

	public UserDTO(Long id, String name, String email, String password) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public UserDTO(User entity) {
		id = entity.getId();
		name = entity.getName();
		email = entity.getEmail();
		password = entity.getPassword();
		for (GrantedAuthority role : entity.getRoles()) {
			roles.add(role.getAuthority());
		}
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public List<String> getRoles() {
		return roles;
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
		UserDTO other = (UserDTO) obj;
		return Objects.equals(id, other.id);
	}

}
