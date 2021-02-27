package org.hbs.v7.beans.model.dataprocess.filter;

import java.io.Serializable;

import org.hbs.v7.beans.model.data.MediatorBean;
import org.hbs.v7.beans.model.dataprocess.OperationalData;
import org.hbs.v7.beans.model.dataprocess.OperationalRoadData;

public class OperationalRoadDataFilter implements Serializable
{
	/**
	 * 
	 */
	private static final long			serialVersionUID	= -3930496576019385191L;
	private static OperationalRoadDataFilter	filterFactory		= null;

	private OperationalRoadDataFilter()
	{

	}

	public static OperationalRoadDataFilter getInstance()
	{
		if (filterFactory == null)
		{
			filterFactory = new OperationalRoadDataFilter();
		}
		return filterFactory;
	}

	public void getRoadDataInfo(MediatorBean mBean, OperationalData operData)
	{
		switch ( mBean.extension )
		{
			case Docx :
			case Doc :
			case ODT :
			case PDF :
			{
				OperationalRoadData roadData = new OperationalRoadData();
				System.out.println("getRoadDataInfo :: ");
				operData.setRoadData(roadData);
				break;
			}
			case HTM :
			case HTML :
			{
				OperationalRoadData roadData = new OperationalRoadData();
				operData.setRoadData(roadData);
				break;
			}
			case Json :
			{
				OperationalRoadData roadData = new OperationalRoadData();
				operData.setRoadData(roadData);
				break;
			}
			case XLS :
			case XLSX :
			{
				OperationalRoadData roadData = new OperationalRoadData();
				operData.setRoadData(roadData);
				
				mBean.excelInstance().getFirstRowNum();
				roadData.setBatch(mBean.excelInstance().getFirstRowNum() + "");
				System.out.println(">>>>>>>>>>operData.getRoadData().getBatch()>>>>>>>>>>> " + operData.getRoadData().getBatch());
				break;
			}
			case Csv :
			{
				OperationalRoadData roadData = new OperationalRoadData();
				operData.setRoadData(roadData);
				break;
			}
			default :
				break;

		}
	}
}
