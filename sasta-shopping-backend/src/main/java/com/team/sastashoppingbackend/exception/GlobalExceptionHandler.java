package com.team.sastashoppingbackend.exception;

import java.util.Date;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionPayload> handleException(Exception ex) {
		ExceptionPayload error = new ExceptionPayload(ex.getMessage(), 500, new Date());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionPayload> handleNotFoundException(NotFoundException ex) {
		ExceptionPayload error = new ExceptionPayload(ex.getMessage(), 404, new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionPayload> handleNotFoundException(ResourceNotFoundException ex) {
		ExceptionPayload error = new ExceptionPayload(ex.getMessage(), 404, new Date());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
