package com.local.dropwizard.demo.repersentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChildObject1 {

	public ChildObject1() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty
	String obj1;
	@JsonProperty
	String obj2;
	public String getObj1() {
		return obj1;
	}
	public void setObj1(String obj1) {
		this.obj1 = obj1;
	}
	public String getObj2() {
		return obj2;
	}
	public void setObj2(String obj2) {
		this.obj2 = obj2;
	}
	
}
