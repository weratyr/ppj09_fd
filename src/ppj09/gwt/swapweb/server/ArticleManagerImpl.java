package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class ArticleManagerImpl extends RemoteServiceServlet implements ArticleManager {
	public int createArticle(Article newArticle) {
		// TODO Auto-generated method stub
		return 1;
	}
	public int deleteArticle() {
		return 1;
	}
	public int updateArticle() {
		return 1;
	}
	public Article readArticle(SearchResult searchResult) {
		return	null;
	}
}
