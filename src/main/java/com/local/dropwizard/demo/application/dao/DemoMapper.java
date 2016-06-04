package com.local.dropwizard.demo.application.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import com.google.common.base.Optional;
import com.local.dropwizard.demo.repersentation.RecordTest;

public class DemoMapper implements ResultSetMapper<RecordTest> {

	public RecordTest map(int arg0, ResultSet arg1, StatementContext arg2)
			throws SQLException {
		RecordTest record = new RecordTest(arg1.getInt("id"),
				arg1.getString("name"), null == arg1.getObject("dt_created") ? " ":
					arg1.getObject("dt_created").toString(), false, 0);

		return record;
	}
}
