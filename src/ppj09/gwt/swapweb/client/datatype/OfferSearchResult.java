/*
 * @(#)ArticleSearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;
import java.util.ArrayList;

import ppj09.gwt.swapweb.client.gui.OfferSearchResultView;
import ppj09.gwt.swapweb.client.gui.SearchResultView;

public class OfferSearchResult implements SearchResult, Serializable {
	private ArrayList<ArticleSearchResult> articles;
	private String offeredBy;
	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfferedBy() {
		return offeredBy;
	}

	public void setOfferedBy(String offeredBy) {
		this.offeredBy = offeredBy;
	}

	public ArrayList<ArticleSearchResult> getArticles() {
		return articles;
	}

	public void setArticles(ArrayList<ArticleSearchResult> articles) {
		this.articles = articles;
	}

	public OfferSearchResult(String offeredBy, ArrayList<ArticleSearchResult> articles) {
		this.offeredBy = offeredBy;
		this.articles = articles;
	}
	
	public OfferSearchResult() {
		this.articles = null;
	}
	
	public SearchResultView getView() {
		return new OfferSearchResultView(this);
	}
}
