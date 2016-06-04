package com.local.dropwizard.demo.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import com.local.dropwizard.demo.repersentation.DemoError;

public class MyExceptionMapper implements ExceptionMapper<Exception> {

	public Response toResponse(Exception exception) {

		if (exception instanceof DemoException) {
			exception.printStackTrace();
			return Response.status(Response.Status.NOT_FOUND)
					.entity(new DemoError(exception.getMessage(), "failed"))
					.type(MediaType.APPLICATION_JSON).build();
		} else {
			System.out.println(exception + "  " + exception.getMessage());
			exception.printStackTrace();
			return Response.status(Response.Status.PRECONDITION_FAILED)
					.entity(exception.getStackTrace())
					.type(MediaType.APPLICATION_JSON).build();
		}
	}

}
