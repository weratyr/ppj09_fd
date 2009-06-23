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
	private String userName;
	private String userPicture;
	
	public UserSearchResult(User user) {
		this.userName = user.getUsername();
		this.userPicture = user.getImage();
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
		// TODO Auto-generated method stub
		return userName;
	}

}
