package com.walmart.congo.model;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;

public class Customer extends AbstractEntity {
	// for DB purpose, auto generated
	// not used for this POC;
	private String id;

	private String firstName;
	private String lastName;
	private String email;

	private boolean validateEmail = true;

	public Customer(String firstName, String lastName, String email) {
		super();
		validate();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;

		// default it to empty for now
		this.id = "";
	}

	public Customer(List<String> fields) {
		this(fields.get(0), fields.get(1), fields.get(2));
	}

	public Customer copy() {
		return new Customer(firstName, lastName, email);
	}

	private void validate() {
		validateNames();
		validatEmail();
	}

	private boolean validateNames() {
		return StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName);
	}

	private boolean validatEmail() {
		EmailValidator emailValidator = EmailValidator.getInstance(true);
		if (!validateEmail || emailValidator.isValid(email)) {
			return true;
		}
		return false;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getId() {
		return id;
	}

}
