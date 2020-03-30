package com.inmar.retail;

public class CustomException extends Exception{

	private String errorMessage;

	public CustomException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

}
