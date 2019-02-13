package com.walmart.congo.repository;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.walmart.congo.repository.helper.EventRepositoryHelper;

class EventRepositoryTest {

	private static EventRepositoryHelper repositoryHelper;

	@BeforeAll
	static void init() {
		repositoryHelper = new EventRepositoryHelper();
	}

	@ParameterizedTest(name = "{index} => eventName={0}, beginDateTime={1}, " + "endDateTime={2}")
	@CsvFileSource(resources = "/event-data.csv")
	public void loadRepository(String eventName, String beginDateTime, String endDateTime, int numberOfSeats) {
		repositoryHelper.saveEntity(Arrays.asList(eventName, beginDateTime, endDateTime));
	}

}
