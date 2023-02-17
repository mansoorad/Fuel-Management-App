package com.ty.fuel_boot.fuelmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundException(NoSuchIdFoundException exception){
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(responseStructure, HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Id Found");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}
}