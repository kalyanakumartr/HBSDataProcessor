package org.hbs.v7.userdefined.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;
import org.hbs.core.util.ICRUDBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_resource_group")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ResourceGroup extends DisplayOrderAndStatus implements ICRUDBean, Comparable<ResourceGroup> // SeedInformationTable
{

	private static final long	serialVersionUID	= 4325284495495810578L;
	protected String			groupId;
	protected String			groupName;

	public ResourceGroup()
	{
		super();
	}

	public ResourceGroup(String groupId)
	{
		super();
		this.groupId = groupId;
	}

	public ResourceGroup(String groupId, String groupName)
	{
		super();
		this.groupId = groupId;
		this.groupName = groupName;
	}

	@Override
	public int compareTo(ResourceGroup o)
	{
		return 0;
	}

	@Id
	@Column(name = "groupId")
	public String getGroupId()
	{
		return groupId;
	}

	@Column(name = "groupName")
	public String getGroupName()
	{
		return groupName;
	}

	public void setGroupId(String groupId)
	{
		this.groupId = groupId;
	}

	public void setGroupName(String groupName)
	{
		this.groupName = groupName;
	}

}
