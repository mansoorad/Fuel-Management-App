package com.ty.fuel_boot.fuelmanagementsystem.exception;

public class WrongEmailIDPasswordException extends RuntimeException {

	
String message= "No Such ID Found In The DataBase";
	
	
	
	public WrongEmailIDPasswordException(String message) {
		super();
		this.message = message;
	}
	
	public WrongEmailIDPasswordException() {
		
	}

	@Override
	public String getMessage() {
		return message;
	}
}
