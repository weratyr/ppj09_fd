/*
 * @(#)ArticleManager.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.SearchResult;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * ArticleManager Interface ist fuer den RPC des ArticleManagerImpl. Das
 * Interface enthaelt die Methoden, die auf der Serverseite aufgerufen werden.
 * 
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version 0.1, 04.05.09
 */
@RemoteServiceRelativePath("ArticleManager")
public interface ArticleManager extends RemoteService {
	public int createArticle(Article newArticle);
	public int deleteArticle();
	public int updateArticle();
	public Article readArticle(SearchResult searchResult);
	public Article getArticle(int articleId);
}