package org.hbs.v7.extractor.data.processor;

import org.hbs.v7.beans.DataInTopicBean;
import org.hbs.v7.beans.model.data.MediatorBean;
import org.hbs.v7.dao.DataAttachmentDao;
import org.hbs.v7.extractor.resume.processor.DataExtractorService;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DataExtractorBase implements IDataExtractor
{

	private static final long	serialVersionUID	= 650213083715426205L;

	DataInTopicBean				inBean;

	@Autowired
	DataExtractorService		dataExtractorService;

	@Autowired
	protected DataAttachmentDao	datDao;

	public DataExtractorBase()
	{
		super();
	}

	public IDataExtractor setInBean(DataInTopicBean inBean)
	{
		this.inBean = inBean;
		return this;
	}

	abstract MediatorBean read();
	
	@Override
	public void execute()
	{
		dataExtractorService.execute(read());
	}


}