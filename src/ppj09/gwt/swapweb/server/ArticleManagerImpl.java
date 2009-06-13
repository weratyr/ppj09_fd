package ppj09.gwt.swapweb.server;

import ppj09.gwt.swapweb.client.datatype.Article;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.serverInterface.ArticleManager;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server side implementation of the RPC service.
 */
public class ArticleManagerImpl extends RemoteServiceServlet implements ArticleManager {
	
	DataBankerQueries db = new DataBankerQueries();
	SessionHandler sh = new SessionHandler();
	
	public int createArticle(Article newArticle) {
		String user = sh.getSession(this.getThreadLocalRequest());
		return db.createArticle(user, newArticle);
	}
	 	
	public int deleteArticle() {
		return 1;
	}
	
	public int updateArticle() {
		return 1;
	}
	
	public Article readArticle(SearchResult searchResult) {
		return null;
	}

	public Article getArticle(int articleId) {
		return null;
		// TODO Auto-generated method stub
		
	}
}
