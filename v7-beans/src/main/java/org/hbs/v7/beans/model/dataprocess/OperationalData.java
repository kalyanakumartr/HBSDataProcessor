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
import org.hbs.v7.beans.model.ICoreBase;
import org.hbs.v7.beans.model.ICoreData;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_data") // ResumeData or InvoiceData -->> ICoreData
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalData implements ICRUDBean, EBusinessKey, ICoreData
{
	private static final long		serialVersionUID	= -4292683338585791631L;
	protected String				dataId;
	protected ICoreBase				coreBase;													// Resume
	protected OperationalRoadData	roadData;													// Embeddable
	protected Set<OperationalTask>	taskList			= new LinkedHashSet<OperationalTask>();	// Production/QualityControl

	public OperationalData()
	{
		super();
		this.dataId = EBusinessKey.EKey.Auto();
	}

	public OperationalData(String dataId, ICoreBase coreBase, OperationalRoadData roadData, Set<OperationalTask> taskList)
	{
		super();
		this.dataId = dataId;
		this.coreBase = coreBase;
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

	@ManyToOne(targetEntity = OperationalProcess.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "dataURN")
	@JsonIgnore
	public ICoreBase getCoreBase()
	{
		return coreBase;
	}

	@Embedded
	public OperationalRoadData getRoadData()
	{
		return roadData;
	}

	@OneToMany(targetEntity = OperationalTask.class, fetch = FetchType.LAZY, mappedBy = "operationalData")
	@Fetch(FetchMode.JOIN)
	@OrderBy("allotedDate ASC")
	public Set<OperationalTask> getTaskList()
	{
		return taskList;
	}

	public void setDataId(String dataId)
	{
		this.dataId = dataId;
	}

	public void setCoreBase(ICoreBase coreBase)
	{
		this.coreBase = coreBase;
	}

	public void setRoadData(OperationalRoadData roadData)
	{
		this.roadData = roadData;
	}

	public void setTaskList(Set<OperationalTask> taskList)
	{
		this.taskList = taskList;
	}
}
