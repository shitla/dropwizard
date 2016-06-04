package com.local.dropwizard.resource;

import io.dropwizard.jackson.Jackson;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.local.dropwizard.demo.repersentation.RecordTest;

public class DemoResourceTest2 {
	private static String FILE_PATH = "F:\\RIV_2012\\STS_WORKSPACE\\dropwizard\\src\\test\\resources\\fixtures\\demo.json";

	private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
	Gson gson = new Gson();

	@Test
	public void serializesToJSON() throws Exception {
		final RecordTest record = new RecordTest(1, "Shitla Mishra",
				"2/12/2014", true, 'c');
		BufferedReader br = new BufferedReader(new FileReader(FILE_PATH));
		// convert the json string back to object
		RecordTest obj = gson.fromJson(br, RecordTest.class);
		System.out.println(gson.toJson(record));
		System.out.println(gson.toJson(obj));
		System.out.println(gson.toJson(record).equals(gson.toJson(obj)));
		System.out.println(obj);
		System.out.println(record);
		System.out.println(obj.equals(record));
		/*
		 * assertThat(MAPPER.writeValueAsString(record))
		 * .isEqualTo(fixture("fixtures/person.json"));
		 */
		//assertThat(gson.toJson(obj).equalsIgnoreCase(gson.toJson(record)));

	}
}
