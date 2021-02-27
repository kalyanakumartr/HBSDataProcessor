package org.hbs.v7.extractor.resume.processor;

import java.util.LinkedHashMap;
import java.util.Map;

import org.hbs.core.util.EnumInterface;
import org.hbs.v7.beans.model.dataprocess.filter.OperationalRoadDataFilter;

public enum EDataOptions implements EnumInterface
{
	RoadDataInfo("", "getRoadDataInfo"); // You can call multiple methods using COMMA separated

	String	clazz;
	String	methods;

	EDataOptions(String clazz, String method)
	{
		this.clazz = clazz;
		this.methods = method;
	}

	EDataOptions set(Class<?> clazz)
	{
		this.clazz = clazz.getCanonicalName();
		return this;
	}

	public static Map<EDataOptions, Class<?>[]> getProcessors()
	{
		Map<EDataOptions, Class<?>[]> optionList = new LinkedHashMap<EDataOptions, Class<?>[]>();
		for (EDataOptions eOpt : EDataOptions.values())
		{
			switch ( eOpt )
			{
				case RoadDataInfo :
				{
					optionList.put(eOpt, toArray(OperationalRoadDataFilter.class)); // You can add multiple filter
					break;
				}
			}
		}
		return optionList;
	}

	private static Class<?>[] toArray(Class<?>... clazz)
	{
		return clazz;
	}

}