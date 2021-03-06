/*
 * @(#)ArticleManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.SearchResult;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ArticleManager Interface ist fuer den RPC des ArticleManagerImpl. Das
 * Interface enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
public interface ArticleManagerAsync {
	public void createArticle(Article newArticle, AsyncCallback<Integer> callback);
	public void deleteArticle(AsyncCallback<Integer> callback);
	public void updateArticle(AsyncCallback<Integer> callback);
	public void readArticle(SearchResult searchResult, AsyncCallback<Article> callback);
	public void getArticle(int articleId, AsyncCallback<Article> callback);
	public void getOwnArticlesList(AsyncCallback<ArrayList<Article>> callback);
}