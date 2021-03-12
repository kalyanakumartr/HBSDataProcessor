package org.hbs.v7.userdefined.model;

import java.sql.Timestamp;

import org.hbs.v7.beans.model.ICoreBase;

public class CoreBaseFactory
{
	public static ICoreBase getInstance(String... identifier)
	{
		OperationalProcess process = new OperationalProcess();
		process.getProducerList().add(0, new CustomerProducer(identifier[0]));
		process.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		process.setStatus(true);
		return process;
	}
}
