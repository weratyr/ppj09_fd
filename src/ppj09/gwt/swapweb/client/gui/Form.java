/*
 * @(#)Form.java      20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.gui;

/**
 * Stellt die Superklasse aller Formularklassen dar.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 * 
 */
public interface Form {
	
	/**
	 * 
	 * @return <code>true</code>  falls die gesendeten Daten korrekt sind 
	 */
	public boolean submit();
}
