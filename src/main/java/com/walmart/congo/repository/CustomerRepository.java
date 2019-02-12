package com.walmart.congo.repository;

import java.util.ArrayList;
import java.util.List;

import com.walmart.congo.AppConstants;
import com.walmart.congo.exception.InvalidUserInputException;
import com.walmart.congo.model.AbstractEntity;
import com.walmart.congo.model.Customer;

public class CustomerRepository implements IRepository {
	private List<Customer> customers;

	public CustomerRepository() {
		customers = new ArrayList<>();
	}

	@Override
	public synchronized void registerEntity(AbstractEntity customer) {
		try {
			customers.add((Customer) customer);
		} catch (ClassCastException ex) {
			throw new InvalidUserInputException(String.format(AppConstants.INVALID_ENTITY_MESSAGE, "Customer"));
		}
	}

	@Override
	public synchronized boolean isRegistered(AbstractEntity customer) {
		try {
			return customers.contains(customer);
		} catch (ClassCastException ex) {
			throw new InvalidUserInputException(String.format(AppConstants.INVALID_ENTITY_MESSAGE, "Customer"));
		}
	}

}
