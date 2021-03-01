package org.hbs.v7.extractor.data.processor;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hbs.v7.beans.model.DataAttachments.EDataTrace;
import org.hbs.v7.beans.model.data.MediatorBean;
import org.springframework.stereotype.Component;

@Component
public class ExcelDataExtractor extends DataExtractorBase 
{
	private static final long	serialVersionUID	= -3403166786849575868L;

	MediatorBean read()
	{
		XSSFWorkbook book = null;
		try
		{
			book = new XSSFWorkbook(inBean.getInputStream());
			MediatorBean mediatorBean = new MediatorBean(inBean.getExtension());
			mediatorBean.setExcel(book.getSheetAt(0));
			return mediatorBean;
		}
		catch (Exception excep)
		{
			System.out.println("We had an error while reading the Word Doc");
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
			try
			{
				if (book != null)
				{
					book.close();
				}
				if (inBean.getInputStream() != null)
				{
					inBean.getInputStream().close();
				}
			}
			catch (Exception ex)
			{
			}
		}
		return null;
	}

}
