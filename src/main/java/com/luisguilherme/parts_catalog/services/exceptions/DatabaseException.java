package com.luisguilherme.parts_catalog.services.exceptions;

@SuppressWarnings("serial")
public class DatabaseException extends RuntimeException {
	
	public DatabaseException(String msg) {
		super(msg);		
	}

}
