/*
 * @(#)ArticleSearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import java.util.ArrayList;

import com.gwtext.client.widgets.Panel;

import ppj09.gwt.swapweb.client.gui.ArticleSearchResultListView;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.OfferSearchResultView;
import ppj09.gwt.swapweb.client.gui.SearchResultView;

public class OfferSearchResult implements SearchResult, Serializable {
	private ArrayList<SearchResult> articles;
	
	public ArrayList<SearchResult> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<SearchResult> articles) {
		this.articles = articles;
	}

	public OfferSearchResult(ArrayList<SearchResult> articles) {
		this.articles = articles;
	}
	
	public OfferSearchResult() {
		this.articles = null;
	}
	
	public SearchResultView getView() {
		return new OfferSearchResultView(this);
	}
}
