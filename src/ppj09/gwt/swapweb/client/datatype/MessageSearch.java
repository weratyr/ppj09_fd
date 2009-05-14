/*
 * @(#)MessageSearch.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import java.util.ArrayList;


/**
 * Enthaelt ein MessageSearch Objekt einer Suchanfrage.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class MessageSearch implements SearchQuery,Serializable {
	// primitive Suche
	private String searchPhrase;
	// auswahl; Benuztername, Betreff, Nachrichttext usw.
	private int typeId;
	public ArrayList<Parameter> getParameters() {
		// TODO Auto-generated method stub
		return null;
	}
}
