package com.walmart.congo.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Disabled
class TicketServiceTest {

	private TicketService ticketService;

	@Test
	void test() {
		fail("Not yet implemented");
	}

	@BeforeEach
	void init() {
		ticketService = new TicketServiceImpl();
	}

	@DisplayName("Test TicketService")
	@Test
	void testBasicSalaryWithInValidSalary() {

		assertThrows(IllegalArgumentException.class, () -> {
		});

	}

	@AfterEach
	void tearDown() {
		ticketService = null;
	}

}
