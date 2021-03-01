package org.hbs.v7.beans.model.dataprocess;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hbs.core.util.EBusinessKey;
import org.hbs.core.util.ICRUDBean;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "operational_data") // ResumeData or InvoiceData
public class OperationalData implements ICRUDBean, EBusinessKey
{
	private static final long		serialVersionUID	= -4292683338585791631L;
	protected String				dataId;
	protected OperationalProcess	operationalProcess;											// Resume
	protected OperationalRoadData	roadData;													// Embeddable
	protected Set<OperationalTask>	taskList			= new LinkedHashSet<OperationalTask>();	// Production/QualityControl

	public OperationalData()
	{
		super();
	}

	public OperationalData(String dataURN)
	{
		super();
		this.dataId = getBusinessKey();
		this.operationalProcess = new OperationalProcess(dataURN);
	}

	public OperationalData(String dataId, OperationalProcess operationalProcess, OperationalRoadData roadData, Set<OperationalTask> taskList)
	{
		super();
		this.dataId = dataId;
		this.operationalProcess = operationalProcess;
		this.roadData = roadData;
		this.taskList = taskList;
	}

	@Override
	public String getBusinessKey(String... combination)
	{
		return EKey.Auto();
	}

	@Id
	@Column(name = "dataId")
	public String getDataId()
	{
		return dataId;
	}

	@ManyToOne(targetEntity = OperationalProcess.class, fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "dataURN")
	public OperationalProcess getOperationalProcess()
	{
		return operationalProcess;
	}

	public void setDataId(String dataId)
	{
		this.dataId = dataId;
	}

	public void setOperationalProcess(OperationalProcess operationalProcess)
	{
		this.operationalProcess = operationalProcess;
	}

	@Embedded
	public OperationalRoadData getRoadData()
	{
		return roadData;
	}

	public void setRoadData(OperationalRoadData roadData)
	{
		this.roadData = roadData;
	}

	@OneToMany(targetEntity = OperationalTask.class, fetch = FetchType.LAZY, mappedBy = "operationalData")
	@Fetch(FetchMode.JOIN)
	//@Where(clause = "fetchBlock = true")
	@OrderBy("allotedDate ASC")
	@JsonIgnore
	public Set<OperationalTask> getTaskList()
	{
		return taskList;
	}

	public void setTaskList(Set<OperationalTask> taskList)
	{
		this.taskList = taskList;
	}

}
