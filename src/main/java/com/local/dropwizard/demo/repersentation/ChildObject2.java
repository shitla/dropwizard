package com.local.dropwizard.demo.repersentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChildObject2 {

	public ChildObject2() {
		// TODO Auto-generated constructor stub
	}

	@JsonProperty
	private int obj1;

	public int getObj1() {
		return obj1;
	}

	public void setObj1(int obj1) {
		this.obj1 = obj1;
	}

	public int getObj2() {
		return obj2;
	}

	public void setObj2(int obj2) {
		this.obj2 = obj2;
	}

	@JsonProperty
	private int obj2;

}
