package com.local.dropwizard.demo.application.dao;

import java.util.Map;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.unstable.BindIn;

import com.local.dropwizard.demo.repersentation.RecordTest;

public interface DemoDAO {

	/*@SqlQuery("select * from test where cn in (<userList>)")
	@RegisterMapper(DemoMapper.class)
	public List<RecordTest> getRecord(@BindIn);*/
	
	@SqlUpdate("INSERT into test values(:recordTest.id,:recordTest.name,:recordTest.dtCreated)")
	public int createRecord(@BindBean("recordTest") RecordTest recordTest);
}
