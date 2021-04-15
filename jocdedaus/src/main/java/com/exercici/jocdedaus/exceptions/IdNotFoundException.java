package com.exercici.jocdedaus.exceptions;

import java.math.BigInteger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public IdNotFoundException(BigInteger id) {
		super("ID: " + id + " not found");
	}

}
