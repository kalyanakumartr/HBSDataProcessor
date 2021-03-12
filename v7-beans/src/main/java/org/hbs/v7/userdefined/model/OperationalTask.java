package org.hbs.v7.userdefined.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="OperationalTask")
@Table(name = "operational_task")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalTask extends OperationalTaskBase implements Serializable
{

	private static final long	serialVersionUID	= 693482289436697214L;
	protected String			taskId;

	public OperationalTask()
	{
		super();
	}

	public OperationalTask(OperationalData operationalData, Timestamp allotedDate, float duration, Timestamp endTime, OperationalStatusReason reason, String remarks, OperationalRoadType roadType,
			Timestamp startTime, OperationalStatus taskStatus, OperationalEmployee taskEmployee, String taskId, String taskTeamName, TaskTeam taskTeam)
	{
		super();
		this.operationalData = operationalData;
		this.allotedDate = allotedDate;
		this.duration = duration;
		this.endTime = endTime;
		this.reason = reason;
		this.remarks = remarks;
		this.roadType = roadType;
		this.startTime = startTime;
		this.taskStatus = taskStatus;
		this.taskEmployee = taskEmployee;
		this.taskId = taskId;
		this.taskTeamName = taskTeamName;
		this.taskTeam = taskTeam;
	}

	@Id
	@Column(name = "taskId")
	public String getTaskId()
	{
		return taskId;
	}

	public void setTaskId(String taskId)
	{
		this.taskId = taskId;
	}

}
