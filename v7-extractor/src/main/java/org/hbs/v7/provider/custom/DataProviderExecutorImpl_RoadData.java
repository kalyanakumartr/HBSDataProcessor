package org.hbs.v7.provider.custom;

import java.io.Serializable;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hbs.v7.beans.MediatorBean;
import org.hbs.v7.userdefined.model.OperationalData;
import org.hbs.v7.userdefined.model.OperationalRoadData;
import org.hbs.v7.userdefined.model.OperationalSubCountry;
import org.hbs.v7.userdefined.model.ResourceGroup;

public class DataProviderExecutorImpl_RoadData implements Serializable
{
	/**
	 * 
	 */
	private static final long					serialVersionUID	= -3930496576019385191L;
	private static DataProviderExecutorImpl_RoadData	filterFactory		= null;

	private DataProviderExecutorImpl_RoadData()
	{

	}

	public static DataProviderExecutorImpl_RoadData getInstance()
	{
		if (filterFactory == null)
		{
			filterFactory = new DataProviderExecutorImpl_RoadData();
		}
		return filterFactory;
	}

	public void getRoadDataInfo(MediatorBean mBean)
	{
		switch ( mBean.extension )
		{
			case Docx :
			case Doc :
			case ODT :
			case PDF :
			{
				OperationalData operData = new OperationalData();
				OperationalRoadData roadData = new OperationalRoadData();
				System.out.println("getRoadDataInfo :: ");
				operData.setRoadData(roadData);
				mBean.coreDataList.add(operData);
				break;
			}
			case HTM :
			case HTML :
			{
				OperationalData operData = new OperationalData();
				OperationalRoadData roadData = new OperationalRoadData();
				System.out.println("getRoadDataInfo :: ");
				operData.setRoadData(roadData);
				mBean.coreDataList.add(operData);
				break;
			}
			case Json :
			{
				OperationalData operData = new OperationalData();
				OperationalRoadData roadData = new OperationalRoadData();
				System.out.println("getRoadDataInfo :: ");
				operData.setRoadData(roadData);
				mBean.coreDataList.add(operData);
				break;
			}
			case XLS :
			case XLSX :
			{
				OperationalData operData = null;
				OperationalRoadData roadData = null;

				XSSFWorkbook wb = mBean.excelInstance().getWorkbook();
				XSSFSheet sheet = wb.getSheetAt(0);

				for (Row row : sheet) // iteration over row using for each loop
				{
					if (row.getRowNum() == 0 || row.getRowNum() == 1)
						continue;
					operData = new OperationalData();
					roadData = new OperationalRoadData();
					operData.setRoadData(roadData);
					mBean.coreDataList.add(operData);

					if (row.getRowNum() == 0 || row.getRowNum() == 1)
						continue;
					if (row.getCell(0).getCellType() == CellType.BLANK && row.getCell(1).getCellType() == CellType.BLANK)
						break;
					System.out.println(">>>>>>>>>>operData.getRoadData().WorkUnit()>>1>>>>>>> " + (new Double(row.getCell(1).getNumericCellValue())).longValue());
					System.out.println(">>>>>>>>>>operData.getRoadData().Country()>>>2>>>>>>> " + row.getCell(2).getStringCellValue());
					System.out.println(">>>>>>>>>>operData.getRoadData().RouteName()>3>>>>>>> " + row.getCell(3).getStringCellValue());
					System.out.println(">>>>>>>>>>operData.getRoadData().WuMiles()>>>4>>>>>>> " + row.getCell(4).getNumericCellValue());
					System.out.println(">>>>>>>>>>operData.getRoadData().Batch()>>>>>5>>>>>>> " + row.getCell(5).getStringCellValue());
					System.out.println(">>>>>>>>>>operData.getRoadData().Group()>>>>>6>>>>>>> " + row.getCell(6).getStringCellValue());

					roadData.setWorkUnitId(((new Double(row.getCell(1).getNumericCellValue())).longValue()) + "");
					roadData.setSubCountry(new OperationalSubCountry(row.getCell(2).getStringCellValue()));
					roadData.setRouteName(row.getCell(3).getStringCellValue());

					roadData.setWuMiles(new Float(row.getCell(4).getNumericCellValue()));
					roadData.setBatch(row.getCell(5).getStringCellValue());
					roadData.setGroup(new ResourceGroup(row.getCell(6).getStringCellValue()));

					System.out.println(">>>>>>>>>>operData.getRoadData().getRow()>>>>>>>>>>> " + row.getRowNum());
				}

				break;
			}
			case Csv :
			{
				OperationalData operData = new OperationalData();
				OperationalRoadData roadData = new OperationalRoadData();
				System.out.println("getRoadDataInfo :: ");
				operData.setRoadData(roadData);
				mBean.coreDataList.add(operData);
				break;
			}
			default :
				break;

		}
	}
}
