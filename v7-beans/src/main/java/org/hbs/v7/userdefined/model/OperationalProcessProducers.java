package org.hbs.v7.userdefined.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hbs.core.beans.model.Producers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_process_producers") 
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalProcessProducers implements Serializable
{
	private static final long		serialVersionUID	= -5286611663179152878L;

	protected OperationalProcess	process;
	protected Producers				producer;
	
	@Id
	@ManyToOne(targetEntity = OperationalProcess.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "dataURN")
	@JsonIgnore
	public OperationalProcess getProcess()
	{
		return process;
	}

	@ManyToOne(targetEntity = Producers.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "producerId")
	@JsonIgnore
	public Producers getProducer()
	{
		return producer;
	}

	public void setProcess(OperationalProcess process)
	{
		this.process = process;
	}

	public void setProducer(Producers producer)
	{
		this.producer = producer;
	}

}
