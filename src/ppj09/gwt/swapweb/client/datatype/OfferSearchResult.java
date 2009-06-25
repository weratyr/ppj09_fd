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
	/**
	 * 	@author André Wagner
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<ArticleSearchResult> articles;
	private String offeredBy;
	private String offeredTo;
	private boolean swapConcluded;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private User user;
	
	public boolean isSwapConcluded() {
		return swapConcluded;
	}

	public void setSwapConcluded(boolean swapConcluded) {
		this.swapConcluded = swapConcluded;
	}

	public String getOfferedTo() {
		return offeredTo;
	}

	public void setOfferedTo(String offeredTo) {
		this.offeredTo = offeredTo;
	}

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

	public OfferSearchResult(int id, String offeredBy, String offeredTo, ArrayList<ArticleSearchResult> articles, boolean swapConcluded) {
		this.offeredBy = offeredBy;
		this.offeredTo = offeredTo;
		this.articles = articles;
		this.id = id;
		this.swapConcluded = swapConcluded;
	}
	
	public OfferSearchResult() {
		this.articles = null;
	}
	
	public SearchResultView getView() {
		return new OfferSearchResultView(this);
	}
}
