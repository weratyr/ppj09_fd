/*
 * @(#)ArticleManagerAsync.java      			 20.04.09
 *
 * Copyright (c) 2008-2009 Project Team 4711
 * All rights reserved.
 */

package ppj09.gwt.swapweb.client.serverInterface;

import ppj09.gwt.swapweb.client.datatype.Article;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * ArticleManagerAsync Interface fuer den RPC des ArticleManagerImpl. Das
 * Interface enthaelt die Methoden, die auf der Serverseite via
 * <b>AsyncCallback</b> aufgerufen werden.
 * 
 * @author Christian Happ
 * @author Projekt Team 4711
 * @version %I%, %G%
 */
public interface ArticleManagerAsync {
	public void createArticle(Article newArticle,
			AsyncCallback<Integer> callback);
}
