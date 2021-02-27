package org.hbs.v7.beans.model.dataprocess;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_task")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalTask implements Serializable
{

	private static final long			serialVersionUID	= 693482289436697214L;
	protected Timestamp					allotedDate;
	protected float						duration;
	protected Timestamp					endTime;
	protected OperationalData			operationalData;
	protected OperationalStatusReason	reason;
	protected String					remarks;
	protected OperationalRoadType		roadType;
	protected Timestamp					startTime;
	protected OperationalEmployee		taskEmployee;
	protected String					taskId;
	protected OperationalStatus			taskStatus;
	protected TaskTeam					taskTeam;
	protected String					taskTeamName;

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

	@Column(name = "allotedDate")
	public Timestamp getAllotedDate()
	{
		return allotedDate;
	}

	@Column(name = "duration")
	public float getDuration()
	{
		return this.duration;
	}

	@Column(name = "endTime")
	public Timestamp getEndTime()
	{
		return endTime;
	}

	@ManyToOne(targetEntity = OperationalData.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "dataId", nullable = false)
	public OperationalData getOperationalData()
	{
		return operationalData;
	}

	@ManyToOne(targetEntity = OperationalStatusReason.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "reasonId", nullable = false)
	public OperationalStatusReason getReason()
	{
		return reason;
	}

	@Column(name = "remarks")
	public String getRemarks()
	{
		return remarks;
	}

	@ManyToOne(targetEntity = OperationalRoadType.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "roadId", nullable = false)
	public OperationalRoadType getRoadType()
	{
		return roadType;
	}

	@Column(name = "startTime")
	public Timestamp getStartTime()
	{
		return startTime;
	}

	@ManyToOne(targetEntity = OperationalEmployee.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "taskEmployeeId", nullable = false)
	public OperationalEmployee getTaskEmployee()
	{
		return taskEmployee;
	}

	@Id
	@Column(name = "taskId")
	public String getTaskId()
	{
		return taskId;
	}

	@ManyToOne(targetEntity = OperationalStatus.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "statusId", nullable = false)
	public OperationalStatus getTaskStatus()
	{
		return taskStatus;
	}

	@ManyToOne(targetEntity = TaskTeam.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "teamId", nullable = false)
	public TaskTeam getTaskTeam()
	{
		return taskTeam;
	}

	@Column(name = "taskTeamName")
	public String getTaskTeamName()
	{
		return taskTeamName;
	}

	public void setAllotedDate(Timestamp allotedDate)
	{
		this.allotedDate = allotedDate;
	}

	public void setDuration(float duration)
	{
		this.duration = duration;
	}

	public void setEndTime(Timestamp endTime)
	{
		this.endTime = endTime;

		Duration duration = Duration.between(this.endTime.toLocalDateTime(), this.startTime.toLocalDateTime());
		this.duration = Math.abs(duration.toMinutes());
	}

	public void setOperationalData(OperationalData operationalData)
	{
		this.operationalData = operationalData;
	}

	public void setReason(OperationalStatusReason reason)
	{
		this.reason = reason;
	}

	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public void setRoadType(OperationalRoadType roadType)
	{
		this.roadType = roadType;
	}

	public void setStartTime(Timestamp startTime)
	{
		this.startTime = startTime;
	}

	public void setTaskEmployee(OperationalEmployee taskEmployee)
	{
		this.taskEmployee = taskEmployee;
	}

	public void setTaskId(String taskId)
	{
		this.taskId = taskId;
	}

	public void setTaskStatus(OperationalStatus status)
	{
		this.taskStatus = status;
	}

	public void setTaskTeam(TaskTeam taskTeam)
	{
		this.taskTeam = taskTeam;
	}

	public void setTaskTeamName(String taskTeamName)
	{
		this.taskTeamName = taskTeamName;
	}
}
