package com.local.dropwizard.demo.repersentation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

public class RecordTest {
	@JsonProperty
	private int id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String dtCreated;
	@JsonProperty
	private boolean isBooleanType;

	@JsonProperty
	private char charField;

	public RecordTest(int id, String name, String dtCreated,
			boolean isBooleanType, int i) {
		this.id = id;
		this.name = name;
		this.dtCreated = dtCreated;
		this.isBooleanType = isBooleanType;
		this.charField = 'c';
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDtCreated() {
		return dtCreated;
	}

	public void setDtCreated(String dtCreated) {
		this.dtCreated = dtCreated;
	}
	/*
	 * @Override public String toString() { return
	 * Objects.toStringHelper(this).add("id",id).add("name",
	 * name).add("dtCreated",dtCreated).add("isBooleanType",
	 * isBooleanType).add("charField", charField).toString(); }
	 */
}
