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

import org.hbs.v7.beans.model.ACoreDataBase;

@Entity
@Table(name = "operational_process") // Resume or Invoices
public class OperationalProcess extends ACoreDataBase
{
	private static final long		serialVersionUID	= 5049651757005693167L;

	protected Set<CustomerProducer>	producerList		= new LinkedHashSet<CustomerProducer>(0);
	protected OperationalData		operationalData;

	public OperationalProcess()
	{
		super();
		this.dataURN = getBusinessKey();
	}
	
	public OperationalProcess(String dataURN)
	{
		super();
		this.dataURN = dataURN;
	}

	// Mapped To Multiple Producers, which means multiple branches
	@ManyToMany( fetch = FetchType.LAZY)
	@JoinTable(name = "operational_process_producers", joinColumns = @JoinColumn(name = "dataURN"), inverseJoinColumns = @JoinColumn(name = "producerId"))
	public Set<CustomerProducer> getProducerList()
	{
		return producerList;
	}

	@ManyToOne(targetEntity = OperationalData.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "dataURN", insertable = false, updatable = false)
	public OperationalData getOperationalData()
	{
		return operationalData;
	}

	public void setProducerList(Set<CustomerProducer> producerList)
	{
		this.producerList = producerList;
	}

	public void setOperationalData(OperationalData operationalData)
	{
		this.operationalData = operationalData;
	}

	@Override
	public String getBusinessKey(String... combination)
	{
		return EKey.Auto();
	}

	@Override
	public String constructCountryTimeZone()
	{
		return null;
	}
}
