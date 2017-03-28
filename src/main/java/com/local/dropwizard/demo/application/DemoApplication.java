package com.local.dropwizard.demo.application;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import org.skife.jdbi.v2.DBI;

import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jdbi.InstrumentedTimingCollector;
import com.local.dropwizard.demo.application.dao.DemoDAO;
import com.local.dropwizard.demo.configuration.DemoConfiguration;
import com.local.dropwizard.demo.exception.MyExceptionMapper;
import com.local.dropwizard.demo.health.DemoHealthCheck;
import com.local.dropwizard.demo.resources.DemoResource;

public class DemoApplication extends Application<DemoConfiguration> {

	public static void main(String[] args) throws Exception {
		new DemoApplication().run(args);
	}

	@Override
	public void run(DemoConfiguration configuration, Environment environment)
			throws Exception {

		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(environment,	configuration.getDataSourceFactory(), "oracle");
		jdbi.setTimingCollector(new InstrumentedTimingCollector(new MetricRegistry()));
		final DemoDAO dao = jdbi.onDemand(DemoDAO.class);
		/*
		 * environment.jersey().register( AuthFactory.binder(new
		 * BasicAuthFactory<String>( new DemoAuthenticator(), "232",
		 * String.class)));
		 */
		// environment.jersey().register(XSSSecurtyRequired.class);

		final DemoResource resource = new DemoResource(configuration.getTemplate(), configuration.getDefaultName(),dao);

		final DemoHealthCheck healthCheck = new DemoHealthCheck(configuration.getTemplate());
		environment.healthChecks().register("template", healthCheck);
		environment.jersey().register(resource);
		environment.jersey().register(new MyExceptionMapper());

	}

	@Override
	public void initialize(Bootstrap<DemoConfiguration> arg0) {
		// TODO Auto-generated method stub
		
	}

}
