package org.hbs.v7.beans.model.dataprocess;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hbs.core.beans.model.Producers;
import org.hbs.core.util.EnumInterface;

@Entity(name = "CustomerProducer")
@DiscriminatorValue("Producer")
public class CustomerProducer extends Producers
{
	public enum EProducerStatus implements EnumInterface
	{
		Pending, Activated, Blocked;
	}

	private static final long	serialVersionUID	= -3890542462537008480L;

	private String				description;
	private EProducerStatus		customerStatus		= EProducerStatus.Pending;

	public CustomerProducer()
	{
		super();
	}
	
	public CustomerProducer(String producerId)
	{
		super();
		this.producerId = producerId;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "customerStatus")
	public EProducerStatus getProducerStatus()
	{
		return customerStatus;
	}

	@Column(name = "description")
	public String getDescription()
	{
		return description;
	}

	public void setProducerStatus(EProducerStatus customerStatus)
	{
		this.customerStatus = customerStatus;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}
