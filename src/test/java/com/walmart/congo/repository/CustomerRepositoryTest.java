package com.walmart.congo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.walmart.congo.repository.helper.CustomerRepositoryHelper;

class CustomerRepositoryTest {

	private static CustomerRepositoryHelper repositoryHelper;

	@BeforeAll
	static void init() {
		repositoryHelper = new CustomerRepositoryHelper();
	}

	@Test
	@Disabled
	public void testIt() {
		File file = new File("src/test/resources/customer-data.csv");
		assertTrue(file.exists());
	}

	@ParameterizedTest
	@Disabled
	@ValueSource(ints = { 1, 2, 3, 4, 5 })
	void valueSourceTest(int param) {
		System.out.println(param);
	}

	@ParameterizedTest(name = "{index} => firstName={0}, lastName={1}, email={2}")
	@CsvFileSource(resources = "/customer-data.csv")
	public void loadRepository(String firstName, String lastName, String email) {
		System.out.println(firstName);
		repositoryHelper.saveEntity(Arrays.asList(firstName, lastName, email));
	}

}
