package org.hbs.v7.beans.model.dataprocess;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hbs.core.beans.model.Producers;
import org.hbs.v7.beans.model.ACoreDataBase;

@Entity
@Table(name = "operational_process") //Resume or Invoices
public class OperationalProcess extends ACoreDataBase
{
	private static final long	serialVersionUID	= 5049651757005693167L;

	protected Set<Producers>	producerList		= new LinkedHashSet<Producers>(0);
	protected OperationalData	operationalData;

	public OperationalProcess()
	{
		super();
	}

	// Mapped To Multiple Producers, which means multiple branches
	@ManyToMany
	@JoinTable(name = "operational_process_producers", joinColumns = @JoinColumn(name = "dataURN"), inverseJoinColumns = @JoinColumn(name = "producerId"))
	public Set<Producers> getProducerList()
	{
		return producerList;
	}

	@ManyToOne(targetEntity = OperationalData.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "dataURN" , insertable = false, updatable = false)
	public OperationalData getOperationalData()
	{
		return operationalData;
	}

	public void setProducerList(Set<Producers> producerList)
	{
		this.producerList = producerList;
	}

	public void setOperationalData(OperationalData operationalData)
	{
		this.operationalData = operationalData;
	}
}
