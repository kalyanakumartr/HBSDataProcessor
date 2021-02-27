package org.hbs.core.beans.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hbs.core.util.ICRUDBean;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "state")
public class State implements ICRUDBean, Comparable<State>
{
	private static final long	serialVersionUID	= -5149419121984598098L;
	protected DisplayOrderAndStatus			country;
	protected String			state;
	protected boolean			status;

	public State()
	{
		super();
	}

	public State(DisplayOrderAndStatus country, String state)
	{
		super();
		this.country = country;
		this.state = state;
	}

	@ManyToOne(targetEntity = Country.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "country", nullable = false)
	@JsonIgnore
	public DisplayOrderAndStatus getCountry()
	{
		return country;
	}

	@Id
	@Column(name = "state")
	public String getState()
	{
		return state;
	}

	@Column(name = "status")
	@JsonIgnore
	public boolean isStatus()
	{
		return status;
	}

	public void setStatus(boolean status)
	{
		this.status = status;
	}

	public void setCountry(DisplayOrderAndStatus country)
	{
		this.country = country;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	@Override
	public int compareTo(State state)
	{
		return this.state.compareTo(state.getState());
	}
}
