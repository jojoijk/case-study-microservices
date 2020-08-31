package com.fisglobal.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class GenericUnprocessableEntityException extends RuntimeException{
	public GenericUnprocessableEntityException(String exception) {
		super(exception);
	}
}
