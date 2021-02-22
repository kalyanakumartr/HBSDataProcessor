package org.hbs.v7.beans.model.channel;

import java.io.Serializable;
import java.util.Date;

import org.hbs.core.beans.model.channel.ConfigurationEmail;

public class KafkaEmailReferenceBean implements Serializable
{
	private static final long	serialVersionUID	= -6990780389417212191L;
	public int					messageNumber;
	public Date					sentDate;
	public ConfigurationEmail	config;

	public KafkaEmailReferenceBean(int messageNumber, Date sentDate, ConfigurationEmail config)
	{
		super();
		this.messageNumber = messageNumber;
		this.sentDate = sentDate;
		this.config = config;
	}

}
