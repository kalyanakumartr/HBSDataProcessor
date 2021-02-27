package org.hbs.v7.beans.model.dataprocess;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hbs.core.util.ICRUDBean;

@Embeddable
public class OperationalRoadData implements ICRUDBean
{
	private static final long		serialVersionUID	= 4846638278449221117L;

	protected String				batch;
	protected String				routeName;
	protected OperationalSubCountry	subCountry;
	protected String				workUnitId;
	protected float					wuMiles;
	protected ResourceGroup			group;

	public OperationalRoadData()
	{
		super();
	}

	public OperationalRoadData(String workUnitId, String routeName, float wuMiles, String batch, OperationalSubCountry subCountry)
	{
		super();
		this.workUnitId = workUnitId;
		this.subCountry = subCountry;
		this.routeName = routeName;
		this.wuMiles = wuMiles;
		this.batch = batch;
	}

	@Column(name = "batch")
	public String getBatch()
	{
		return batch;
	}

	@Column(name = "routeName")
	public String getRouteName()
	{
		return routeName;
	}

	@ManyToOne(targetEntity = OperationalSubCountry.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "subCountry")
	public OperationalSubCountry getSubCountry()
	{
		return subCountry;
	}

	@Column(name = "workUnitId")
	public String getWorkUnitId()
	{
		return workUnitId;
	}

	@Column(name = "wuMiles")
	public float getWuMiles()
	{
		return wuMiles;
	}

	@ManyToOne(targetEntity = ResourceGroup.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "groupId")
	public ResourceGroup getGroup()
	{
		return group;
	}

	public void setGroup(ResourceGroup group)
	{
		this.group = group;
	}

	public void setBatch(String batch)
	{
		this.batch = batch;
	}

	public void setRouteName(String routeName)
	{
		this.routeName = routeName;
	}

	public void setSubCountry(OperationalSubCountry subCountry)
	{
		this.subCountry = subCountry;
	}

	public void setWorkUnitId(String workUnitId)
	{
		this.workUnitId = workUnitId;
	}

	public void setWuMiles(float wuMiles)
	{
		this.wuMiles = wuMiles;
	}

}
