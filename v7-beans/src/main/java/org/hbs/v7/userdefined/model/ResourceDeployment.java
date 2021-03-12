package org.hbs.v7.userdefined.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;
import org.hbs.core.util.ICRUDBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_resource_deployment")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ResourceDeployment extends DisplayOrderAndStatus implements ICRUDBean, Comparable<ResourceDeployment> // SeedInformationTable
{

	private static final long	serialVersionUID	= 4325284495495810578L;
	protected String			deploymentId;
	protected String			deploymentTaskName;

	public ResourceDeployment()
	{
		super();
	}

	public ResourceDeployment(String deploymentId, String deploymentTaskName)
	{
		super();
		this.deploymentId = deploymentId;
		this.deploymentTaskName = deploymentTaskName;
	}

	@Override
	public int compareTo(ResourceDeployment o)
	{
		return 0;
	}

	@Id
	@Column(name = "deploymentId")
	public String getDeploymentId()
	{
		return deploymentId;
	}

	@Column(name = "deploymentTaskName")
	public String getDeploymentTaskName()
	{
		return deploymentTaskName;
	}

	public void setDeploymentId(String deploymentId)
	{
		this.deploymentId = deploymentId;
	}

	public void setDeploymentTaskName(String deploymentTaskName)
	{
		this.deploymentTaskName = deploymentTaskName;
	}

}
