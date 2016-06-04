package com.local.dropwizard.demo.repersentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ParentObject {

	public ParentObject() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty
	private String name;
	@JsonProperty
	private Object childObject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getChildObject() {
		return childObject;
	}

	public void setChildObject(Object childObject) {
		this.childObject = childObject;
	}
}
