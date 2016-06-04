package com.local.dropwizard.demo.repersentation;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DemoRepersention {

	private long id;

	@Length(max = 3)
	private String content;

	public DemoRepersention() {
		// Jackson deserialization
	}

	public DemoRepersention(long id, String content) {
		this.id = id;
		this.content = content;
	}

	@JsonProperty
	public long getId() {
		return id;
	}

	@JsonProperty
	public String getContent() {
		return content;
	}
}
