package com.dhakre.rohit.responses;

public class BaseResponse {

	private boolean successful;
	private String message;

	public BaseResponse() {
		super();
	}

	public BaseResponse(boolean successful, String message) {
		super();
		this.successful = successful;
		this.message = message;
	}

	public boolean isSuccessful() {
		return successful;
	}

	public void setSuccessful(boolean successful) {
		this.successful = successful;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
