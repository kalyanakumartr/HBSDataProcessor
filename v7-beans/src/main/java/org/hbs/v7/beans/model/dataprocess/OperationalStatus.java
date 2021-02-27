package org.hbs.v7.beans.model.dataprocess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_status")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalStatus extends DisplayOrderAndStatus implements Serializable //Seed Information Table
{

	private static final long	serialVersionUID	= -4924591397656538119L;

	protected String			description;
	protected String			statusName;
	protected String			statusId;

	public OperationalStatus()
	{
		super();
	}

	public OperationalStatus(String statusId, String statusName, String description)
	{
		super();
		this.statusId = statusId;
		this.statusName = statusName;
		this.description = description;
	}

	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}

	@Column(name = "statusName")
	public String getStatusName()
	{
		return statusName;
	}

	@Id
	@Column(name = "statusId")
	public String getStatusId()
	{
		return statusId;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}

	public void setStatusId(String statusId)
	{
		this.statusId = statusId;
	}

}
