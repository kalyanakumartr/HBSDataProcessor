package org.hbs.v7.extractor.data.processor;

import java.io.IOException;

import javax.mail.MessagingException;

import org.hbs.v7.beans.DataInTopicBean;
import org.hbs.v7.kafka.IReaderKafkaConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class DataExtractConsumersMain implements IReaderKafkaConstants
{
	private static final long	serialVersionUID	= -772482917892822104L;
	private final Logger LOGGER = LoggerFactory.getLogger(DataExtractConsumersMain.class);

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { DOCUMENT, DOCUMENT_EXPEDITE, }), groupId = DATA_EXTRACT_GROUP)
	public void documentDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#documentDataExtractor# -> Partition %d message -> %s", partition, payload));

		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		WordDataExtractor.getInstance(inBean).execute();

	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { OPENOFFICE, OPENOFFICE_EXPEDITE }), groupId = DATA_EXTRACT_GROUP)
	public void openOfficeDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#openOfficeDataExtractor# -> Partition %d message -> %s", partition, payload));

		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		OpenOfficeDataExtractor.getInstance(inBean).execute();

	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { PDF, PDF_EXPEDITE }), groupId = DATA_EXTRACT_GROUP)
	public void pdfDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#pdfDataExtractor# -> Partition %d message -> %s", partition, payload));

		System.out.println(">>>>>>>>>>>>>>>>>>>>...........STARTS..........>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println(">>>>>>>>>>pdfDataExtractor>>>>>>>>>>>>>>>>\n" + payload);
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		PDFDataExtractor.getInstance(inBean).execute();
		
		System.out.println(">>>>>>>>>>>>>>>>>>>>...........ENDS..........>>>>>>>>>>>>>>>>>>>>>>>>");

	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { HTML, HTML_EXPEDITE }), groupId = DATA_EXTRACT_GROUP)
	public void htmlDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#htmlDataExtractor# -> Partition %d message -> %s", partition, payload));

		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		HTMLDataExtractor.getInstance(inBean).execute();

	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { JSON, JSON_EXPEDITE }), groupId = DATA_EXTRACT_GROUP)
	public void jsonDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#jsonDataExtractor# -> Partition %d message -> %s", partition, payload));

		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		JSONDataExtractor.getInstance(inBean).execute();

	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { EXCEL, EXCEL_EXPEDITE }), groupId = DATA_EXTRACT_GROUP)
	public void excelDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#excelDataExtractor# -> Partition %d message -> %s", partition, payload));

		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		ExcelDataExtractor.getInstance(inBean).execute();

	}

	@KafkaListener(topicPartitions = @TopicPartition(topic = DATA_EXTRACT_TOPIC, partitions = { CSV, CSV_EXPEDITE }), groupId = DATA_EXTRACT_GROUP)
	public void csvDataExtractor(@Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, String payload) throws IOException, MessagingException
	{
		LOGGER.info(String.format("##DataExtractConsumersMain#csvDataExtractor# -> Partition %d message -> %s", partition, payload));

		DataInTopicBean inBean = new ObjectMapper().readValue(payload, DataInTopicBean.class);

		CSVDataExtractor.getInstance(inBean).execute();

	}
}
