package com.local.dropwizard.demo.repersentation;

public class DemoError {

	private String Message;
	private String Status;

	public DemoError(String message, String status) {
		super();
		Message = message;
		Status = status;
	}

	public DemoError() {

	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
