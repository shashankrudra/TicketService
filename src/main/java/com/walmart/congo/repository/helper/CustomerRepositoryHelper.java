package com.walmart.congo.repository.helper;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.Validate;

import com.walmart.congo.AppConstants;
import com.walmart.congo.model.Customer;
import com.walmart.congo.repository.CustomerRepository;
import com.walmart.congo.repository.IRepository;

public class CustomerRepositoryHelper implements IRepositoryHelper {

	private IRepository repository = new CustomerRepository();

	@Override
	public void saveEntity(List<String> fields) {
		validate(fields);

		Customer tCustomer = new Customer(fields);
		repository.registerEntity(tCustomer);
	}

	private void validate(List<String> fields) {
		Validate.noNullElements(fields);
		Validate.validIndex(fields, 2);
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

		Customer tCustomer = new Customer(fields[0], fields[1], fields[2]);
		repository.registerEntity(tCustomer);
	}
}
