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
 * Das Interface SearchResult dient zur Darstellung eines SearchResultView type.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface SearchResult extends Serializable {
	public SearchResultView getView();
}
