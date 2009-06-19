/*
 * @(#)UserSearch.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

/**
 * Suchanfrage nach einem User
 * 
 * @author Christian, André
 * @version 0.1, 17.05.09
 */
public class UserSearchQuery extends User implements SearchQuery {
	private String searchPhrase;
	
	public UserSearchQuery() {
		
	}

	public UserSearchQuery(String searchPhrase) {
		super();
		this.searchPhrase = searchPhrase;
	}

	public String getSearchPhrase() {
		return searchPhrase;
	}

	public void setSearchPhrase(String searchPhrase) {
		this.searchPhrase = searchPhrase;
	}
	
}
