/*
 * @(#)User.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Der Datentyp welcher zwischen Client und Server ausgetauscht wird, und ueber
 * den DataBanker in die DB abgelegt wird.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class User implements Serializable {	


	private String firstName;
	private String lastName;
	private String street;
	private String houseNumber;
	private String zip;
	private String city;
	private String username;
	private String email;


	/**
	 * @param firstName
	 *            the firstName to set
	 */
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the firstName textField
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param lastName
	 *            the firstName to set
	 */
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the lastName textField
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * @param street
	 *            the street to set
	 */
	
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the firstName textField
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @param houseNumber
	 *            the houseNumber to set
	 */
	
	public void setHouseNumber(String number) {
		this.houseNumber = number;
	}

	/**
	 * @return the houseNumber textField
	 */
	public String getHouseNumber() {
		return houseNumber;
	}
	
	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the zipCode textField
	 */
	public String getZip() {
		return zip;
	}
	
	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the city textField
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * @param eMail
	 *            the eMail to set
	 */
	
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the eMail textField
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the username textField
	 */
	public String getUsername() {
		return username;
	}
}