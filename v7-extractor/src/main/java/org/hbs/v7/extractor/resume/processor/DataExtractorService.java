package org.hbs.v7.extractor.resume.processor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hbs.core.kafka.IKafkaConstants;
import org.hbs.v7.beans.model.data.MediatorBean;
import org.hbs.v7.beans.model.dataprocess.OperationalData;
import org.hbs.v7.dao.OperationalDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataExtractorService implements IKafkaConstants
{
	private static final long			serialVersionUID	= 7157231262042487975L;

	private static DataExtractorService	extractor			= null;

	@Autowired
	OperationalDataDao					operationalDataDao;

	public void execute(MediatorBean inBean)
	{
		try
		{
			List<OperationalData> operDataList = new ArrayList<OperationalData>();
			Map<EDataOptions, Class<?>[]> rMap = EDataOptions.getProcessors();
			Object object = null;
			System.out.println(">>>>>OperationalData>>STARTS>>>>>> >>>>>>>>>>> >>>>>>>>>>> >>>>>>>>> >>>>>>>>>>>>>> >>>>>>>>>>>>>");
			Method classMethod;
			for (EDataOptions eOpt : rMap.keySet())
			{
				System.out.println(eOpt.name() + " >>>> " + eOpt.methods);
				for (Class<?> clazz : rMap.get(eOpt))
				{
					classMethod = clazz.getMethod("getInstance", new Class[0]);
					object = classMethod.invoke(null, new Object[0]);

					for (String $method : eOpt.methods.split(","))
					{
						try
						{
							System.out.println(object.getClass().getSimpleName() + " >>>> " + $method + " <<<< ");
							Method method = object.getClass().getMethod($method.trim(), new Class[] { MediatorBean.class, List.class });
							method.invoke(object, inBean, operDataList);
						}
						catch (NoSuchMethodException excep)
						{
							System.out.printf(">>>>>>>>>>> %s method NOT available in %s class<<<<<<<<<<<<<<<<<<<<<<<<<<\n", $method, clazz.getSimpleName());
						}
					}

				}
			}
			for (OperationalData operData : operDataList)
			{
				if (operData != null)
					operationalDataDao.save(operData);
			}
			System.out.println(">>>>>OperationalData>>END>>>>>> >>>>>>>>>>> >>>>>>>>>>> >>>>>>>>> >>>>>>>>>>>>>> >>>>>>>>>>>>>");
			// System.out.println(">>>>>>>OperationalData>>>>>> " + new Gson().toJson(rData));
		}
		catch (Exception excep)
		{
			excep.printStackTrace();
		}
	}

	public static DataExtractorService getInstance()
	{
		if (extractor == null)
		{
			extractor = new DataExtractorService();
		}
		return extractor;
	}
}
