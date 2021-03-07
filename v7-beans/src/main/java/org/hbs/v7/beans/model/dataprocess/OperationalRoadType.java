package org.hbs.v7.beans.model.dataprocess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_road_type")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalRoadType extends DisplayOrderAndStatus implements Serializable //Seed Information Table
{

	private static final long	serialVersionUID	= -4924591397656538119L;

	protected String			description;
	protected String			roadType;
	protected String			roadTypeId;

	public OperationalRoadType()
	{
		super();
	}

	public OperationalRoadType(String roadTypeId, String roadType, String description)
	{
		super();
		this.roadTypeId = roadTypeId;
		this.roadType = roadType;
		this.description = description;
	}

	public OperationalRoadType(String roadTypeId)
	{
		super();
		this.roadTypeId = roadTypeId;
	}

	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}

	@Column(name = "roadType")
	public String getRoadType()
	{
		return roadType;
	}

	@Id
	@Column(name = "roadTypeId")
	public String getRoadTypeId()
	{
		return roadTypeId;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setRoadType(String roadType)
	{
		this.roadType = roadType;
	}

	public void setRoadTypeId(String roadTypeId)
	{
		this.roadTypeId = roadTypeId;
	}

}
