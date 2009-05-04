/*
 * @(#)SearchManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import com.google.gwt.user.client.rpc.RemoteService;

/**
 * SearchHandler Interface ist fuer den RPC des SearchHandlerImpl. Das Interface
 * enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 */
public interface SearchHandler extends RemoteService {
	public ArrayList<SearchResult> search(SearchQuery searchQuery);
}
