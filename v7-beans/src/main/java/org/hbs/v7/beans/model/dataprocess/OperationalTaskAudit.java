package org.hbs.v7.beans.model.dataprocess;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "OperationalTaskAudit")
@Table(name = "operational_task_audit")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalTaskAudit extends OperationalTaskBase implements Serializable
{

	private static final long	serialVersionUID	= 693482289436697214L;
	protected long				autoId;
	protected String			taskId;

	public OperationalTaskAudit()
	{
		super();
	}

	public OperationalTaskAudit(OperationalData operationalData, Timestamp allotedDate, float duration, Timestamp endTime, OperationalStatusReason reason, String remarks, OperationalRoadType roadType,
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

	@Column(name = "taskId")
	public String getTaskId()
	{
		return taskId;
	}

	@Id
	@Column(name = "autoId")
	public long getAutoId()
	{
		return autoId;
	}

	public void setAutoId(long autoId)
	{
		this.autoId = autoId;
	}

	public void setTaskId(String taskId)
	{
		this.taskId = taskId;
	}

}
