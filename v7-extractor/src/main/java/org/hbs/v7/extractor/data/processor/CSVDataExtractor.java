package org.hbs.v7.extractor.data.processor;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.hbs.v7.beans.model.DataAttachments.EDataTrace;
import org.hbs.v7.beans.model.data.MediatorBean;
import org.springframework.stereotype.Component;

@Component
public class CSVDataExtractor extends DataExtractorBase implements IDataExtractor
{
	private static final long	serialVersionUID	= -3403166786849575868L;
	
	MediatorBean read()
	{
		try
		{
			CSVParser csvParser = new CSVParser(new FileReader(inBean.getOutputFile()), CSVFormat.DEFAULT);
			MediatorBean mediatorBean = new MediatorBean(inBean.getExtension());
			mediatorBean.setCsv(csvParser);
			return mediatorBean;

		}
		catch (Exception excep)
		{
			System.out.println("We had an error while reading the Open Office Document");
			if (inBean.isExternal() == false) // Internal Flow
			{
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				excep.printStackTrace(pw);
				datDao.updateReadStatus(inBean.getAttachmentAutoId(), EDataTrace.UnableToRead.name(), sw.toString());
			}
		}
		finally
		{
		}
		return null;
	}
}
