package com.walmart.congo.service;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

class TicketServiceTest {

	private static TicketService ticketService;

	@BeforeAll
	static void init() {
		ticketService = new TicketServiceImpl();
	}

	@ParameterizedTest(name = "{index} => emailId={0}, eventName={1}, beginDateTime={2}, endDateTime={2}, numberOfSeats={3}")
	@CsvFileSource(resources = "/booking-requests.csv")
	public void loadRepository(String emailId, String eventName, String beignDateTime, String endDateTime,
			int numberOfSeats) {
		ticketService.findAndHoldSeats(numberOfSeats, emailId);
		System.out.println(emailId);
	}

	@AfterAll
	static void tearDown() {
		ticketService = null;
	}

}
