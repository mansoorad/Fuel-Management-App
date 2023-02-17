package com.ty.fuel_boot.fuelmanagementsystem.exception;

public class NoSuchIdFoundException extends RuntimeException {
	private String message = "No such Id found in the Database";

	public NoSuchIdFoundException(String message) {
		super();
		this.message = message;
	}

	public NoSuchIdFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}
	
	
}
