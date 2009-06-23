/*
 * @(#)UserSearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import ppj09.gwt.swapweb.client.gui.SearchResultView;
import ppj09.gwt.swapweb.client.gui.UserSearchResultView;

/**
 * Stellt den Datentpye einer Benutzersuche dar. 
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class UserSearchResult implements SearchResult, Serializable {
	private String username;
	private String userPicture;
	private String firstname;
	private String lastname;
	private String city;
	
	public UserSearchResult(User user) {
		this.username = user.getUsername();
		this.userPicture = user.getImage();
		this.firstname = user.getFirstName();
		this.lastname = user.getLastName();
		this.city = user.getCity();
	}
	
	public UserSearchResult(String string, String string2) {
		// TODO Auto-generated constructor stub
	}
	
	public UserSearchResult(){
		
		
	}

	/**
	 * Gibt ein SearchResultView Objekt vom Server zur�ck
	 */
	public SearchResultView getView() {
		return new UserSearchResultView(this);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(String userPicture) {
		this.userPicture = userPicture;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


}
