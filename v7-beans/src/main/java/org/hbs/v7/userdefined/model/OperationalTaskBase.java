package org.hbs.v7.userdefined.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Duration;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class OperationalTaskBase implements Serializable
{
	private static final long serialVersionUID = 666568526136628251L;
	protected Timestamp allotedDate;
	protected float duration;
	protected Timestamp endTime;
	protected OperationalData operationalData;
	protected OperationalStatusReason reason;
	protected String remarks;
	protected OperationalRoadType roadType;
	protected Timestamp startTime;
	protected OperationalEmployee taskEmployee;
	protected OperationalStatus taskStatus;
	protected TaskTeam taskTeam;
	protected String taskTeamName;

	public OperationalTaskBase()
	{
		super();
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
	@JoinColumn(name = "roadTypeId", nullable = false)
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
	
	public void setReason(String reasonId)
	{
		this.reason = new OperationalStatusReason(reasonId);
	}


	public void setRemarks(String remarks)
	{
		this.remarks = remarks;
	}

	public void setRoadType(OperationalRoadType roadType)
	{
		this.roadType = roadType;
	}
	
	public void setRoadType(String roadId)
	{
		this.roadType = new OperationalRoadType(roadId);
	}

	public void setStartTime(Timestamp startTime)
	{
		this.startTime = startTime;
	}

	public void setTaskEmployee(OperationalEmployee taskEmployee)
	{
		this.taskEmployee = taskEmployee;
	}

	public void setTaskStatus(OperationalStatus status)
	{
		this.taskStatus = status;
	}
	
	public void setTaskStatus(String status)
	{
		this.taskStatus = new OperationalStatus(status);
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