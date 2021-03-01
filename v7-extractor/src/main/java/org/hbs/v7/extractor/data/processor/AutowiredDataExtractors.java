package org.hbs.v7.extractor.data.processor;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AutowiredDataExtractors implements Serializable
{
	private static final long	serialVersionUID	= 3733658308511719590L;

	@Autowired
	CSVDataExtractor			csvDataExtractor;
	
	@Autowired
	ExcelDataExtractor			excelDataExtractor;
	
	@Autowired
	HTMLDataExtractor			htmlDataExtractor;
	
	@Autowired
	JSONDataExtractor			jsonDataExtractor;
	
	@Autowired
	OpenOfficeDataExtractor		openOfficeDataExtractor;
	
	@Autowired
	PDFDataExtractor			pdfDataExtractor;
	
	@Autowired
	WordDataExtractor			wordDataExtractor;

	
	public AutowiredDataExtractors()
	{
		super();
	}

}