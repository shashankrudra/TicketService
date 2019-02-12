package com.walmart.congo.repository;

import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.walmart.congo.repository.helper.CustomerRepositoryHelper;

class CustomerRepositoryTest {

	private CustomerRepositoryHelper repositoryHelper;

	@BeforeAll
	void init() {
		repositoryHelper = new CustomerRepositoryHelper();
	}

	// @ParameterizedTest(name = "{index} => a= {0}, b= {1}, sum= {2}")
	@Test
	@ParameterizedTest
	@CsvFileSource(resources = "customer-data.csv", numLinesToSkip = 1)
	private void loadRepository(String firstName, String lastName, String email) {
		repositoryHelper.saveEntity(Arrays.asList(firstName, lastName, email));
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
