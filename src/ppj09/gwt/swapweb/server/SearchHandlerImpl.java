package ppj09.gwt.swapweb.server;

import java.util.ArrayList;

import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.MessageSearchQuery;
import ppj09.gwt.swapweb.client.datatype.OfferSearchResult;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.User;
import ppj09.gwt.swapweb.client.datatype.UserSearchQuery;
import ppj09.gwt.swapweb.client.datatype.UserSearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SearchHandlerImpl extends RemoteServiceServlet implements SearchHandler {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DataBankerQueries db = new DataBankerQueries();

	public ArrayList<SearchResult> search(ArticleSearchQuery articleSearch) {		
		return db.getArticleSearchResults(articleSearch);
	}
	
	public ArrayList<SearchResult> search(UserSearchQuery userSearch) {
		return db.getUserSearchResults(userSearch);
	}

	public ArrayList<ArticleSearchResult> search(MessageSearchQuery articleSearch) {
		return null;
	}

	public ArrayList<SearchResult> getOfferedArticles(int articleId) {
		return db.getOfferedArticles(articleId);
	}
}
