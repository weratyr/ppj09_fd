package ppj09.gwt.swapweb.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import ppj09.gwt.swapweb.client.datatype.ArticleSearch;
import ppj09.gwt.swapweb.client.datatype.ArticleSearchResult;
import ppj09.gwt.swapweb.client.datatype.MessageSearch;
import ppj09.gwt.swapweb.client.datatype.SearchQuery;
import ppj09.gwt.swapweb.client.datatype.SearchResult;
import ppj09.gwt.swapweb.client.datatype.UserSearch;
import ppj09.gwt.swapweb.client.datatype.UserSearchResult;
import ppj09.gwt.swapweb.client.serverInterface.SearchHandler;

public class SearchHandlerImpl extends RemoteServiceServlet implements SearchHandler {
	
	public ArrayList<SearchResult> search(ArticleSearch articleSearch) {
		System.out.println("sHandler");
		ArrayList<SearchResult> dummyResults = new ArrayList<SearchResult>();
		dummyResults.add(new ArticleSearchResult("Swap Web", "http://www.geocities.com/hollywood/cinema/2636/pic-coll1/it-clown.jpg"));
		dummyResults.add(new ArticleSearchResult("Walroß", "http://www.zoo-augsburg.de/server2/content/die-tiere_infotafeln/content_tafel-09-02.jpg"));
		ArrayList<String> strArr = new ArrayList<String>();
		strArr.add("abc");
		return dummyResults;
	}
	
	public ArrayList<UserSearchResult> search(UserSearch articleSearch) {
		ArrayList<UserSearchResult> dummyResults = new ArrayList<UserSearchResult>();
		dummyResults.add(new UserSearchResult("Hans", "Fulda"));
		dummyResults.add(new UserSearchResult("Walroß", "Fels"));
		return dummyResults;
	}

	public ArrayList<ArticleSearchResult> search(MessageSearch articleSearch) {
		return null;
	}
	
//	public ArrayList<SearchResult> search(SearchQuery searchQuery) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
