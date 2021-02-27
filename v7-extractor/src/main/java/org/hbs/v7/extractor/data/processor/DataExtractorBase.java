package org.hbs.v7.extractor.data.processor;

import java.io.Serializable;

import org.hbs.v7.beans.DataInTopicBean;
import org.hbs.v7.beans.model.data.MediatorBean;
import org.hbs.v7.dao.DataAttachmentDao;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class DataExtractorBase implements Serializable
{

	private static final long serialVersionUID = 650213083715426205L;
	
	@Autowired
	protected DataAttachmentDao datDao;

	public DataExtractorBase()
	{
		super();
	}
	
	abstract MediatorBean read(DataInTopicBean inBean);

}