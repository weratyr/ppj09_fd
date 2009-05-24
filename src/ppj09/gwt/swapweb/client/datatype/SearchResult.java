/*
 * @(#)SearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import ppj09.gwt.swapweb.client.gui.SearchResultView;

/**
 * Das Interface für alle typspezifischen Suchergebnisse.
 * 
 * @author Christian Happ, André Wagner
 * @version 0.1, 14.05.09
 */
public interface SearchResult extends Serializable {
	/**
	 * Liefert das Widget zurück welches aus einer der typspezifischen Views 
	 * in client.gui erzeugt wird. Diese Methode wird i.d.R. bei einem 
	 * SearchResult Objekt aufgerufen und per Polymorphie an die betreffende 
	 * Subklasse weiterdelegiert.
	 * Der Rückgabetyp ist das Interface SearchResultView
	 */
	public SearchResultView getView();
}
