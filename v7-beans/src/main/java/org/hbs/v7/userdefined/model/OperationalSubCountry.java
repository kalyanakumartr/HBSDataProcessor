package org.hbs.v7.userdefined.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hbs.core.beans.model.DisplayOrderAndStatus;
import org.hbs.core.util.ICRUDBean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "operational_subcountry")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class OperationalSubCountry  extends DisplayOrderAndStatus implements ICRUDBean, Comparable<OperationalSubCountry> //Seed Information Table
{

	private static final long	serialVersionUID	= 8372130046238222330L;
	protected String			country;
	protected String			countryName;

	public OperationalSubCountry()
	{
		super();
	}

	public OperationalSubCountry(String country)
	{
		super();
		this.country = country;
	}
	
	public OperationalSubCountry(String country, String countryName, boolean status)
	{
		super();
		this.country = country;
		this.countryName = countryName;
		this.status = status;
	}

	@Override
	public int compareTo(OperationalSubCountry country)
	{
		return countryName.compareTo(country.getCountryName());
	}

	@Id
	@Column(name = "country")
	public String getCountry()
	{
		return country;
	}

	@Column(name = "countryName")
	public String getCountryName()
	{
		return countryName;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}
}
