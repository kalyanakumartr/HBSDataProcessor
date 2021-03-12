package org.hbs.v7.userdefined.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hbs.core.beans.model.Users;
import org.hbs.core.util.EnumInterface;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "OperationalEmployee")
@DiscriminatorValue("OEmployee")
public class OperationalEmployee extends Users
{

	public enum EWorkMode implements EnumInterface
	{
		WFH, WFO;
	}

	private static final long		serialVersionUID	= 8708144241732401029L;

	protected ResourceDeployment	deploy;
	protected ResourceGroup			group;
	protected OperationalEmployee	reportingTo;
	protected String				teamName;
	protected EWorkMode				workMode			= EWorkMode.WFO;

	public OperationalEmployee()
	{
		super();
		this.employeeId = getBusinessKey();
		this.userType = EUserType.Employee;
	}

	@Transient
	@JsonIgnore
	public String getBusinessKey()
	{
		return EKey.Auto();
	}

	@ManyToOne(targetEntity = ResourceDeployment.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "deploymentId")
	public ResourceDeployment getDeploy()
	{
		return deploy;
	}

	@ManyToOne(targetEntity = ResourceGroup.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "groupId")
	public ResourceGroup getGroup()
	{
		return group;
	}

	@ManyToOne(targetEntity = OperationalEmployee.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "reportingTo")
	public OperationalEmployee getReportingTo()
	{
		return reportingTo;
	}

	@Column(name = "teamName")
	public String getTeamName()
	{
		return teamName;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "workMode")
	public EWorkMode getWorkMode()
	{
		return workMode;
	}

	public void setDeploy(ResourceDeployment deploy)
	{
		this.deploy = deploy;
	}

	public void setGroup(ResourceGroup group)
	{
		this.group = group;
	}

	public void setReportingTo(OperationalEmployee reportingTo)
	{
		this.reportingTo = reportingTo;
	}

	public void setTeamName(String teamName)
	{
		this.teamName = teamName;
	}

	public void setWorkMode(EWorkMode workMode)
	{
		this.workMode = workMode;
	}
}
