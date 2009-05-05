/*
 * @(#)ArticleSearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.SearchResultView;
import com.google.gwt.user.client.ui.Composite;

/**
 * Enthaelt ein ArticleSearchResult Objekt einer Suchanfrage.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 */
public class ArticleSearchResult extends Composite implements SearchResult,Serializable  {
	public SearchResultView getView() {
		return new ArticleSearchResultView();
	}
}
