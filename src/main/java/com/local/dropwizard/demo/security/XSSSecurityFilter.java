package com.local.dropwizard.demo.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.owasp.esapi.ESAPI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class XSSSecurityFilter implements ContainerRequestFilter {


	private static final Logger LOG = LoggerFactory
			.getLogger(XSSSecurityFilter.class);	

	@Override
	public void filter(ContainerRequestContext request) throws IOException {
		 // Clean the query strings
		
        cleanParams(request.getUriInfo().getQueryParameters()) ;
 
        // Clean the headers
        cleanParams( request.getHeaders() );
 
        // Clean the cookies
        //cleanParams( request.getCookies() );
 
      	
	}

	/**
	 * Apply the XSS filter to the parameters
	 * 
	 * @param parameters
	 * @param type
	 */
	private MultivaluedMap<String, String> cleanParams(MultivaluedMap<String, String> parameters) {
		LOG.debug("Checking for XSS Vulnerabilities: {}", parameters);
		
		MultivaluedMap<String, String> cleanedPparameters=new MultivaluedHashMap<String, String>();

		for (Map.Entry<String, List<String>> params : parameters.entrySet()) {
			String key = params.getKey();
			List<String> values = params.getValue();

			List<String> cleanValues = new ArrayList<String>();
			for (String value : values) {
				cleanValues.add(stripXSS(value));
			}

			cleanedPparameters.put(key, cleanValues);
		
		}
		LOG.debug("XSS Vulnerabilities removed: {}", parameters);
		
		return cleanedPparameters;
	}

	/**
	 * Strips any potential XSS threats out of the value
	 * 
	 * @param value
	 * @return
	 */
	public String stripXSS(String value) {
		
		System.out.println("before  clean value"+value);
		if (value == null)
			return null;

		// Use the ESAPI library to avoid encoded attacks.
		value = ESAPI.encoder().canonicalize(value);

		// Avoid null characters
		value = value.replaceAll("\0", "");

		// Clean out HTML
		value = Jsoup.clean(value, Whitelist.none());
		
		System.out.println("clean value"+value);

		return value;
	}

	
}
