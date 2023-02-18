package com.ty.fuel_boot.fuelmanagementsystem.exception;

public class NoSuchIdFoundException extends RuntimeException {

	private String message;

	public NoSuchIdFoundException(String message) {
		super();

		this.message = message;
	}

	public NoSuchIdFoundException() {

	}

	@Override
	public String getMessage() {
		return message;

	}
}
