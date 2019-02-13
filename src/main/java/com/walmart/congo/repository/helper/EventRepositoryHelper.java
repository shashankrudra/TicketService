package com.walmart.congo.repository.helper;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.walmart.congo.AppConstants;
import com.walmart.congo.model.Event;
import com.walmart.congo.repository.EventRepository;
import com.walmart.congo.repository.IRepository;

public class EventRepositoryHelper implements IRepositoryHelper {

	private IRepository repository = new EventRepository();

	@Override
	public void saveEntity(List<String> fields) {
		validate(fields);

		Event tEvent = new Event(fields);
		repository.registerEntity(tEvent);
	}

	private void validate(List<String> fields) {
		Validate.noNullElements(fields);
		Validate.validIndex(fields, 2);
		ValidateDateFields(fields.get(1), fields.get(2));
	}

	private void ValidateDateFields(String... dateTime) {
		for (String td : dateTime) {
			AppConstants.EVENT_DATETIME_FORMATTER.parse(td);
		}
	}

	private void validate(String[] fields) {
		Validate.noNullElements(fields);
		Validate.validIndex(fields, 2);
	}

	public void registerBulkCsvData(String[] csvDataLine) {
		Arrays.stream(csvDataLine).forEach(line -> {
			registerCsvData(line);
		});
	}

	public void registerCsvData(String csvDataLine) {
		String[] fields = csvDataLine.split(AppConstants.DATA_SEPARATOR_COMMA);
		validate(fields);

		Event tEvent = new Event(fields[0], fields[1], fields[2]);
		repository.registerEntity(tEvent);
	}
}
