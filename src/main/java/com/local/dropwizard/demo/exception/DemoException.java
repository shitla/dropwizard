package com.local.dropwizard.demo.exception;

public class DemoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DemoException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		}

	public DemoException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public DemoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DemoException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	

}
