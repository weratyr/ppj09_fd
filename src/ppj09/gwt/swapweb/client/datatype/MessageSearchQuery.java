/*
 * @(#)MessageSearch.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

/**
 * Suchanfrage nach einer Message
 * 
 * @author Christian, André
 * @version 0.1, 17.05.09
 */
public class MessageSearchQuery extends Message implements SearchQuery {
	// primitive Suche
	private String searchPhrase;
}
