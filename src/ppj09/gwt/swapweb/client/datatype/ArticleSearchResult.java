/*
 * @(#)ArticleSearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

import com.gwtext.client.widgets.Panel;

import ppj09.gwt.swapweb.client.gui.ArticleSearchResultListView;
import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.SearchResultView;

/**
 * Enthaelt ein ArticleSearchResult Objekt einer Suchanfrage.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 14.06.09
 */
public class ArticleSearchResult implements SearchResult, Serializable {
	private String title;
	private int id;
	private String userName;
	private String pictureUrl;
	private String offerScope;

	public ArticleSearchResult() {
		this.title = null;
		this.pictureUrl = null;
		this.userName = null;
		this.offerScope = null;
		this.id = 0;
	}
	
	public SearchResultView getView() {
		return new ArticleSearchResultView(this);
	}
	
	
	public ArticleSearchResult(String title, String userName, String pictureUrl, int id, String offerScope) {
		this.title = title;
		this.pictureUrl = pictureUrl;
		this.userName = userName;
		this.id = id;
		this.offerScope = offerScope;
	}

	public int getId() {
		return id;
	}
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPictureUrl() {
		return pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}

	public void setOfferScope(String offerScope) {
		this.offerScope = offerScope;
	}

	public String getOfferScope() {
		return offerScope;
	}

}
