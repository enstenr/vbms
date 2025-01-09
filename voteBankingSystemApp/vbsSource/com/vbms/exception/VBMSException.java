package com.vbms.exception;

public class VBMSException extends Exception {
	private String errorMessage;

	public VBMSException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public VBMSException() {

	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return this.errorMessage;
	}

}
