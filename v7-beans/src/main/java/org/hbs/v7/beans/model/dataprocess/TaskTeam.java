package org.hbs.v7.beans.model.dataprocess;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;
import org.hbs.core.util.ICRUDBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_task_team")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class TaskTeam extends DisplayOrderAndStatus implements ICRUDBean, Comparable<TaskTeam> // SeedInformationTable
{

	private static final long	serialVersionUID	= 4325284495495810578L;
	protected String			teamId;
	protected String			teamName;

	public TaskTeam()
	{
		super();
	}

	public TaskTeam(String teamId, String teamName)
	{
		super();
		this.teamId = teamId;
		this.teamName = teamName;
	}

	@Override
	public int compareTo(TaskTeam o)
	{
		return 0;
	}

	@Id
	@Column(name = "teamId")
	public String getTeamId()
	{
		return teamId;
	}

	@Column(name = "teamName")
	public String getTeamName()
	{
		return teamName;
	}

	public void setTeamId(String teamId)
	{
		this.teamId = teamId;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

}
