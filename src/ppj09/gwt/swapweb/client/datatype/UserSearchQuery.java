/*
 * @(#)UserSearch.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

/**
 * Suchanfrage nach einem User
 * 
 * @author Christian, André
 * @version 0.1, 20.06.09
 */
public class UserSearchQuery implements SearchQuery {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String firstname;
	private String lastname;
	private String job;
	private String city;
	private String hobbies;
	private boolean onlyPic;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public boolean isOnlyPic() {
		return onlyPic;
	}
	public void setOnlyPic(boolean onlyPic) {
		this.onlyPic = onlyPic;
	}
	
	
}
