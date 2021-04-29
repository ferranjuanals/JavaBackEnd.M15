package com.exercici.jocdedaus.exceptions;

import com.nimbusds.oauth2.sdk.util.StringUtils;

public class NameNotValidException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private static String message;

	public NameNotValidException(String playerName) {
		super(message);
		if(StringUtils.isBlank(playerName)) {
			message = "A valid name is necessary";
		}else {
			message = "The name " + playerName + " is already taken";
		}
	}
}
