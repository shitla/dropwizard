package com.local.dropwizard.demo.validation;

import com.local.dropwizard.demo.exception.DemoException;

public class DemoValidator {

	public void validate(String name) {
		try {
			System.out.println(name);
			if ("Shitla".equalsIgnoreCase(name)) {
				System.out.println(name);
				throw new DemoException("Validation Error");
			} else {
				throw new Exception("Error not ");
			}

		} catch (Exception ex) {
			// throw new Exception("Error not ");
		}

	}

}
