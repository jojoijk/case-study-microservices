package com.fisglobal.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class LibraryApiGenericException extends RuntimeException{
	public LibraryApiGenericException(String exception) {
		super(exception);
	}
}
