package ppj09.gwt.swapweb.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchQuery;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.MessageSearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.UserSearchQuery;
import ppj09.gwt.swapweb.client.datatype.UserSearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;

public class SearchHandlerImpl extends RemoteServiceServlet implements SearchHandler {
	
	public ArrayList<SearchResult> search(ArticleSearchQuery articleSearch) {
		ArrayList<SearchResult> dummyResults = new ArrayList<SearchResult>();
		dummyResults.add(new ArticleSearchResult("Swap Web", "Hans", "http://www.geocities.com/hollywood/cinema/2636/pic-coll1/it-clown.jpg"));
		dummyResults.add(new ArticleSearchResult("Walroß", "Karl", "http://www.zoo-augsburg.de/server2/content/die-tiere_infotafeln/content_tafel-09-02.jpg"));
		return dummyResults;
	}
	
	public ArrayList<SearchResult> search(UserSearchQuery userSearch) {
		ArrayList<SearchResult> dummyResults = new ArrayList<SearchResult>();
		dummyResults.add(new UserSearchResult("Hans", "Fulda"));
		dummyResults.add(new UserSearchResult("Walroßss", "Fels"));
		return dummyResults;
	}

	public ArrayList<ArticleSearchResult> search(MessageSearchQuery articleSearch) {
		return null;
	}
	
//	public ArrayList<SearchResult> search(SearchQuery searchQuery) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
