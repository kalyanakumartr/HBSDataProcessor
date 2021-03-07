package org.hbs.v7.beans.model.dataprocess;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_status_reason")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalStatusReason  extends DisplayOrderAndStatus implements Serializable //Seed Information Table
{

	private static final long serialVersionUID = 1917435007545296138L;
	protected String			description;
	protected String			reason;
	protected String			reasonId;
	protected OperationalStatus	operationalStatus;
	
	public OperationalStatusReason()
	{
		super();
	}

	public OperationalStatusReason(String reasonId)
	{
		super();
		this.reasonId = reasonId;
	}
	
	public OperationalStatusReason(OperationalStatus status, String description, String reason, String reasonId)
	{
		super();
		this.operationalStatus = status;
		this.description = description;
		this.reason = reason;
		this.reasonId = reasonId;
	}

	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}

	@Column(name = "reason")
	public String getReason()
	{
		return reason;
	}

	@Id
	@Column(name = "reasonId")
	public String getReasonId()
	{
		return reasonId;
	}

	@ManyToOne(targetEntity = OperationalStatus.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "statusId", nullable = false)
	@JsonIgnore
	public OperationalStatus getOperationalStatus()
	{
		return operationalStatus;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
	}

	public void setReasonId(String reasonId)
	{
		this.reasonId = reasonId;
	}

	public void setOperationalStatus(OperationalStatus operationalStatus)
	{
		this.operationalStatus = operationalStatus;
	}
}
