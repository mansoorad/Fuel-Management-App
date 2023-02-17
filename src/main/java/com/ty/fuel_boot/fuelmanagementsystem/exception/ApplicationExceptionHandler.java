package com.ty.fuel_boot.fuelmanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.fuel_boot.fuelmanagementsystem.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> noSuchIdFoundExceptionHandler(NoSuchIdFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("ID Not FOund");
		responseStructure.setData(exception.getMessage());
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.NOT_FOUND);
		return responseEntity;
	}
	@ExceptionHandler
	public ResponseEntity<ResponseStructure<String>> wrongEmailIDPasswordExceptionHandler(
			WrongEmailIDPasswordException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<String>();
		responseStructure.setStatus(HttpStatus.UNAUTHORIZED.value());
		responseStructure.setMessage("Wrong Email ID & Password");
		responseStructure.setData(exception.getMessage());
		ResponseEntity<ResponseStructure<String>> responseEntity = new ResponseEntity<ResponseStructure<String>>(
				responseStructure, HttpStatus.UNAUTHORIZED);
		return responseEntity;
	}

}
