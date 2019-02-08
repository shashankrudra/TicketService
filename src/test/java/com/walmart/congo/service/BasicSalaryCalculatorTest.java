package com.walmart.congo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BasicSalaryCalculatorTest {

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	private BasicSalaryCalculator basicSalaryCalculator;
	 
	  @BeforeEach
	  void init() {
	    basicSalaryCalculator = new BasicSalaryCalculator();
	  }
	 
	  @DisplayName("Test add user successfully.")
	  @Test
	  void testBasicSalaryWithValidSalary() {
	    double basicSalary = 4000;
	    basicSalaryCalculator.setBasicSalary(basicSalary);
	 
	    double expectedSocialInsurance = basicSalary * 0.25;
	    assertEquals(expectedSocialInsurance, basicSalaryCalculator.getSocialInsurance());
	 
	    double expectedAddionalBonus = basicSalary * 0.1;
	    assertEquals(expectedAddionalBonus, basicSalaryCalculator.getAdditionalBonus());
	 
	    double expectedGross = basicSalary + expectedSocialInsurance + expectedAddionalBonus;
	    assertEquals(expectedGross, basicSalaryCalculator.getGrossSalary());
	 
	  }
	 
	  @DisplayName("Test BasicSalaryCalculator with invalid salary")
	  @Test
	  void testBasicSalaryWithInValidSalary() {
	 
	    double basicSalary = -100;
	    assertThrows(IllegalArgumentException.class, () -> {
	      basicSalaryCalculator.setBasicSalary(basicSalary);
	    });
	 
	  }
	 
	  @AfterEach
	  void tearDown() {
	    basicSalaryCalculator = null;
	  }

}
