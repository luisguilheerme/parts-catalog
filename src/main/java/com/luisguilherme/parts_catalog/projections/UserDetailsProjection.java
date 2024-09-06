package com.luisguilherme.parts_catalog.projections;

public interface UserDetailsProjection {

	String getUsername();
	String getPassword();
	Long getRoleId();
	String getAuthority();
	
}
