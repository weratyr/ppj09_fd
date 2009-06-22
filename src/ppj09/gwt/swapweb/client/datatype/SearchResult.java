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
 * Das Interface f�r alle typspezifischen Suchergebnisse.
 * 
 * @author Christian Happ, Andr� Wagner
 * @version 0.1, 14.06.09
 */
public interface SearchResult extends Serializable {
	/**
	 * Liefert das Widget zur�ck welches aus einer der typspezifischen Views 
	 * in client.gui erzeugt wird. Diese Methode wird i.d.R. bei einem 
	 * SearchResult Objekt aufgerufen und per Polymorphie an die betreffende 
	 * Subklasse weiterdelegiert.
	 * Der R�ckgabetyp ist das Interface SearchResultView
	 */
	public SearchResultView getView();
}
