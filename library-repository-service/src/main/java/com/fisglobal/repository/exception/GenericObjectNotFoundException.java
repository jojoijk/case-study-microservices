package com.fisglobal.repository.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GenericObjectNotFoundException extends RuntimeException {

	public GenericObjectNotFoundException(String exception) {
		super(exception);
	}

}
