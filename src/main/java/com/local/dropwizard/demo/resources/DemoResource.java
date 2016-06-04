package com.local.dropwizard.demo.resources;

import io.dropwizard.auth.Auth;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import com.local.dropwizard.demo.application.dao.DemoDAO;
import com.local.dropwizard.demo.auth.User;
import com.local.dropwizard.demo.repersentation.ChildObject1;
import com.local.dropwizard.demo.repersentation.ChildObject2;
import com.local.dropwizard.demo.repersentation.ParentObject;
import com.local.dropwizard.demo.repersentation.RecordTest;

@Path("/demo")
@Produces(MediaType.APPLICATION_JSON)
public class DemoResource {

	public final String template;
	private final String defaultName;
	private final AtomicLong counter;
	private DemoDAO dao;
	private static final Logger LOG = Logger.getLogger(DemoResource.class);

	public DemoResource(String template, String defaultName, DemoDAO dao) {
		this.template = template;
		this.defaultName = defaultName;
		this.counter = new AtomicLong();
		this.dao = dao;
	}

	@GET
	@Timed
	public Response sayHello(@QueryParam("name") Optional<String> name) {
		final String value = String.format(template, name.or(defaultName));
		RecordTest recordTest = null;
		// recordTest= new RecordTest(2,"Shitla",getCurrentDate());
		// dao.createRecord(recordTest);
		System.out.println("Test");
		// List<RecordTest> records = dao.getRecord();
		// System.out.println(records);
		// new DemoValidator().validate(name.or(defaultName));
		LOG.info("This is logggggggggggggggggggggggggggggggggggggggggggggggggggg");
		return Response.status(Response.Status.OK).entity("Done")
				.type(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Timed
	@Path("/auth")
	public Response getAuthenticated(@Auth User user) {
		System.out.println(user.getPassword() + "password");
		System.out.println(user.getUsername());
		return Response.status(Response.Status.FORBIDDEN)
				.entity("Successwqfdsf").type(MediaType.APPLICATION_JSON)
				.build();

	}

	private static String getCurrentDate() {

		String date = "24/MAR/2014";
		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		java.util.Date today = null;
		try {
			today = dateFormat.parse(date);
			System.out.println(dateFormat.format(today));
		} catch (ParseException e) {

			e.printStackTrace();
		}
		// return new java.sql.Date(today.getTime());
		return dateFormat.format(today);

	}

	/*
	 * public static void main(String ...strings){
	 * System.out.println(getCurrentDate());
	 * System.out.println(getCurrentDate()); }
	 */

	@GET
	@Timed
	@Path("/castObject")
	public Response castObject(ParentObject obj) {
		if ("str".equalsIgnoreCase(obj.getName())) {
			ChildObject1 chobj = (ChildObject1) obj.getChildObject();
			System.out.println(chobj.getObj1() + chobj.getObj2());
		} else {
			ChildObject2 chobj = (ChildObject2) obj.getChildObject();
			System.out.println(chobj.getObj1() + chobj.getObj2());
		}

		return Response.status(Response.Status.FORBIDDEN)
				.entity("Successwqfdsf").type(MediaType.APPLICATION_JSON)
				.build();

	}

}
