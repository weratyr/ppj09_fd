/*
 * @(#)SearchManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.UserSearchQuery;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * SearchHandler Interface ist fuer den RPC des SearchHandlerImpl. Das Interface
 * enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface SearchHandlerAsync {
	public void search(ArticleSearchQuery searchQuery, AsyncCallback<ArrayList<SearchResult>> callback);
	//public ArrayList<SearchResult> search(UserSearchQuery searchQuery);
}
