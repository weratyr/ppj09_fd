/*
 * @(#)ArticleSearchResult.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.datatype;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

import ppj09.gwt.swapweb.client.gui.ArticleSearchResultView;
import ppj09.gwt.swapweb.client.gui.SearchResultView;

/**
 * Enthaelt ein ArticleSearchResult Objekt einer Suchanfrage.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public class ArticleSearchResult implements SearchResult, IsSerializable {
	public String title;
	public String userName;
	public String pictureUrl;
	
	public ArticleSearchResult() {
		this.title = null;
		this.pictureUrl = null;
		this.userName = null;
	}
	
	public ArticleSearchResult(String title, String userName, String pictureUrl) {
		this.title = title;
		this.pictureUrl = pictureUrl;
		this.userName = userName;
	}
	
	public SearchResultView getView() {
		return new ArticleSearchResultView(this);
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

}
